package com.zhangsan.web.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;
import com.zhangsan.common.enums.ResultCode;
import com.zhangsan.common.exception.ServiceException;
import com.zhangsan.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangsan
 * @Date 2022/5/9 20:23
 */
@Slf4j
@Configuration
@Lazy
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * warn级别错误码列表
     */
    private static final List<Integer> WARN_LEVEL_CODE_LIST = Lists.newArrayList(ResultCode.SERVICE_EXCEPTION.getCode());

    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add((request, response, handler, e) -> {
            Result result = new Result();
            String message = e.getMessage();
            if (e instanceof ServiceException) {
                result.setCode(ResultCode.SERVICE_EXCEPTION).setMessage(e.getMessage());
            } else {
                result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                            request.getRequestURI(), handlerMethod.getBean().getClass().getName(),
                            handlerMethod.getMethod().getName(),e.getMessage());
                } else {
                    message = e.getMessage();
                }
            }
            if (WARN_LEVEL_CODE_LIST.contains(result.getCode())) {
                log.warn(message, e);
            } else {
                log.error(message, e);
            }
            responseResult(response, result);
            return new ModelAndView();
        });
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
