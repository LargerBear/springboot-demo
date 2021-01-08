package com.example.springbootdemo.common;

import com.example.springbootdemo.model.DemoUser;
import com.example.springbootdemo.service.DemoUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/1/8 16:17</br>
 * @since JDK 1.8
 *
 *
 * 工具类中注入被spring容器管理的类
 * 并在本类中设置静态方法
 *
 *
 */
@Component
@Slf4j
public class TestUtil {

    @Resource
    private DemoUserService userService;


    /**
     * 本类
     */
    private static TestUtil testUtil;

    @PostConstruct
    public void init(){
        testUtil = this;
        testUtil.userService = this.userService;
    }

    public static DemoUser getUser(){

        return testUtil.userService.findUser("1");
    }

}
