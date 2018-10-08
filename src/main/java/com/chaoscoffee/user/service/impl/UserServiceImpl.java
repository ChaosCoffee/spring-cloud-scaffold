package com.chaoscoffee.user.service.impl;

import com.chaoscoffee.user.entity.User;
import com.chaoscoffee.user.mapper.UserMapper;
import com.chaoscoffee.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaoscoffee
 * @since 2018-10-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
