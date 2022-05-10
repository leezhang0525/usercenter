package com.zhangsan.service.user;

import com.zhangsan.entity.user.TUser;

/**
 * @author zhangsan
 * @Date 2022/5/9 11:41
 */

public interface UserService {

    /**
     * 用户id获取用户信息
     * @param userId
     * @return
     */
    TUser getUserById (Integer userId);

    /**
     * 用户名获取用户信息
     * @param userName
     * @return
     */
    TUser getUserByUserName(String userName);
}
