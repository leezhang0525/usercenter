package com.zhangsan.web.controller;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zhangsan.common.response.Result;
import com.zhangsan.common.response.ResultGenerator;
import com.zhangsan.dto.req.login.LoginReqDTO;
import com.zhangsan.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private DefaultKaptcha captchaProducer;

    @Autowired
    private LoginService loginService;

    /**
     * 用户注册 TODO
     * @return
     */
    @PostMapping("/register")
    public Result register(){
        return ResultGenerator.genSuccessResult();
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @Description 获取图片验证码
     */
    @RequestMapping("/captcha-image")
    public void captchaImage(HttpServletRequest request,
                                     HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        // 文本
        String capText = captchaProducer.createText();
        request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY,
                capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginReqDTO loginReqDTO){
        return ResultGenerator.genSuccessResult(loginService.login(loginReqDTO));
    }

    /**
     * 登录
     * @return
     */
    @GetMapping("/test")
    public Result test(){
        return ResultGenerator.genSuccessResult(loginService.test());
    }
}
