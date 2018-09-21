package com.chaoscoffee.service.impl;

import com.chaoscoffee.dao.entity.User;
import com.chaoscoffee.dao.repository.UserRepository;
import com.chaoscoffee.service.UserService;
import com.chaoscoffee.util.Sequence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author chaoscoffee
 * @date 2018/9/20
 * @description
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findUserByUserCode(Long userCode) {
        return userRepository.findUserByUserCode(userCode);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setUserCode(new Sequence(0, 0).nextId());
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }
}
