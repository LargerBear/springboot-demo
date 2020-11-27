package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/11/25 9:30</br>
 * @since JDK 1.8
 */
@RestController
public class TestUserController {

    @Resource
    private User user;

    @GetMapping("/user")
    public User getUser(){
        return user;
    }
}
