package com.example.springbootdemo.service;

import com.example.springbootdemo.model.DemoUser;

/**
 * @author LargerBear</ br>
 * date: 2020/11/25 15:13</br>
 * @since JDK 1.8
 */
public interface DemoUserService {


    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    DemoUser findUser(String id);
}
