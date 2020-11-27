package com.example.springbootdemo.service;

import com.example.springbootdemo.model.DemoUser;

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
public interface DemoUserService {


    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    DemoUser findUser(String id);
}
