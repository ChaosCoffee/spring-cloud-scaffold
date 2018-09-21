package com.chaoscoffee.controller;

import com.chaoscoffee.dao.entity.User;
import com.chaoscoffee.result.Results;
import com.chaoscoffee.result.base.Result;
import com.chaoscoffee.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chaoscoffee
 * @date 2018/9/20
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/gerUser")
    public Result getUser(@RequestParam("userCode") Long userCode) {
        User user = userService.findUserByUserCode(userCode);
        return user == null ? Results.noOk("用户信息未找到") : Results.ok(user);
    }

    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody User user) {
        User u = userService.saveUser(user);
        return user == null ? Results.noOk("用户保存失败") : Results.kvOk("userCode", u.getUserCode());
    }
}
