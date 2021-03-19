package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LargerBear</ br>
 * date: 2020/11/25 14:56</br>
 * @since JDK 1.8
 */
@Mapper
public interface DemoUserMapper {

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    DemoUser selectById(@Param("id") String id);
}
