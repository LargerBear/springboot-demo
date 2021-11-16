package com.example.springbootdemo.demo.mapper;

import com.example.springbootdemo.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Package: com.example.springbootdemo.demo.mapper
 * @Description: <Mapper接口>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

        }

