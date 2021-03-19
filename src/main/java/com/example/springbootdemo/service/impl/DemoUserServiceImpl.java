package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mapper.DemoUserMapper;
import com.example.springbootdemo.model.DemoUser;
import com.example.springbootdemo.service.DemoUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LargerBear</ br>
 * date: 2020/11/25 15:13</br>
 * @since JDK 1.8
 */
@Service
public class DemoUserServiceImpl implements DemoUserService {


    @Resource
    private DemoUserMapper userMapper;

    @Override
    public DemoUser findUser(String id) {
        return userMapper.selectById(id);
    }
}
