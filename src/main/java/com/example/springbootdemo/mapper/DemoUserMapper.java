package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
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
