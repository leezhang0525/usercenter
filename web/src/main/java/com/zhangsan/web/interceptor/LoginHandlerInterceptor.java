package com.zhangsan.web.interceptor;

import com.google.common.collect.Lists;
import com.zhangsan.common.constants.ResConstants;
import com.zhangsan.common.exception.ServiceException;
import com.zhangsan.entity.user.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhangsan
 * @Date 2022/5/10 11:30
 */
@Component
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor,ExcludePath {

    private static final List<String> excludePathList = Lists.newArrayList("/login/*");

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TUser loginUser = (TUser) request.getSession().getAttribute("user");
        if ( loginUser == null ){
            throw new ServiceException(ResConstants.MSG_USER_NOT_LOGIN_ERROR);
        }
        return true;
    }

    @Override
    public List<String> getExcludePath() {
        return excludePathList;
    }
}
