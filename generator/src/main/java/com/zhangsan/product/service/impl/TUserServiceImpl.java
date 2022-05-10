package com.zhangsan.product.service.impl;

import com.zhangsan.product.pojo.entity.TUser;
import com.zhangsan.product.mapper.TUserMapper;
import com.zhangsan.product.service.TUserService;
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
