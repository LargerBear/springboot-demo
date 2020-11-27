package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mapper.DemoUserMapper;
import com.example.springbootdemo.model.DemoUser;
import com.example.springbootdemo.service.DemoUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
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
