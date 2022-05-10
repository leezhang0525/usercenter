package com.zhangsan.service.login;

import com.zhangsan.dto.req.login.LoginReqDTO;

/**
 * @author zhangsan
 * @Date 2022/5/9 11:42
 */
public interface LoginService {

    /**
     * 登录
     * @param loginReqDTO
     * @return
     */
    String login (LoginReqDTO loginReqDTO);

    String test ();
}
