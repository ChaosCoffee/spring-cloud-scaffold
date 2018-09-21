package com.chaoscoffee.dao.repository;

import com.chaoscoffee.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chaoscoffee
 * @date 2018/9/19
 * @description
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserCode(Long userCode);
}
