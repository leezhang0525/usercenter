package com.zhangsan.web.controller;

import com.zhangsan.common.response.Result;
import com.zhangsan.common.response.ResultGenerator;
import com.zhangsan.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoginService loginService;

    /**
     * test
     * @return
     */
    @GetMapping("/test")
    public Result test(){
        return ResultGenerator.genSuccessResult(loginService.test());
    }
}
