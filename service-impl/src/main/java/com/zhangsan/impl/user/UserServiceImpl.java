package com.zhangsan.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhangsan.dao.user.TUserMapper;
import com.zhangsan.entity.user.TUser;
import com.zhangsan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangsan
 * @Date 2022/5/9 16:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;


    @Override
    public TUser getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public TUser getUserByUserName(String userName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",userName);
        TUser user = userMapper.selectOne(wrapper);
        return user;
    }
}
