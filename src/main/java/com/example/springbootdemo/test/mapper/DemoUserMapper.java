package com.example.springbootdemo.test.mapper;

import com.example.springbootdemo.test.entity.DemoUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Package: com.example.springbootdemo.test.mapper
 * @Description: <Mapper接口>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
@Mapper
public interface DemoUserMapper extends BaseMapper<DemoUser> {

        }

