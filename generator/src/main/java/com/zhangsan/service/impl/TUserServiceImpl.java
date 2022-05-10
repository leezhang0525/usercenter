package com.zhangsan.service.impl;

import com.zhangsan.entity.TUser;
import com.zhangsan.repository.TUserMapper;
import com.zhangsan.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhangsan
 * @since 2022-05-05
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
