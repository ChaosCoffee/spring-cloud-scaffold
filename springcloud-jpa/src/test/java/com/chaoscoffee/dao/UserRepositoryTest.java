package com.chaoscoffee.dao;

import com.chaoscoffee.SpringcloudJpaApplicationTests;
import com.chaoscoffee.dao.entity.User;
import com.chaoscoffee.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author chaoscoffee
 * @date 2018/9/19
 * @description
 */
@Slf4j
public class UserRepositoryTest extends SpringcloudJpaApplicationTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void saveTest() throws Exception {
        User user = new User();
        user.setUserCode(1L);
        user.setName("郑龙飞");
        user.setTotalAmount(BigDecimal.TEN);
        User result = userRepository.save(user);
        log.info(result.toString());
        Assert.assertNotNull(user.getId());
    }

/*    @Test
    public void findOneTest() throws Exception {
        User user = userRepository.findOne(1);
        log.info(user.toString());
        Assert.assertNotNull(user);
        Assert.assertTrue(1l == user.getId());
    }*/


}
