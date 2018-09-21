package com.chaoscoffee.service;

import com.chaoscoffee.dao.entity.User;

/**
 * @author chaoscofee
 * @date 2018/9/20
 * @description
 */
public interface UserService {
    /**
     * 根据用户编号查询用户信息
     *
     * @param userCode
     * @return
     */
    User findUserByUserCode(Long userCode);

    User saveUser(User user);

}
