package com.chaoscoffee.mapper;

import com.chaoscoffee.SpringcloudMybatisplusApplicationTests;
import com.chaoscoffee.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chaoscoffee
 * @date 2018/10/8
 * @description
 */
public class UserMapperTests extends SpringcloudMybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

}
