package com.example.springbootdemo.config;

import com.example.springbootdemo.common.DateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/11/25 9:26</br>
 * @since JDK 1.8
 */

/**
 * 通过注解形式读取配置信息，将该类交由spring容器管理，然后注入即可使用
 *
 * 方式一：添加@ConfigurationProperties注解
 * 通过前缀的方式读取，其中  ' - ' 代表驼峰, ' _ ' 代表非驼峰
 *
 * 方式二：通过@Value方式精确获取，可支持el表达式
 *
 *
 * @author Administrator
 */
@ConditionalOnProperty(name = "user-config", havingValue = "true", matchIfMissing = true)
/*
     代表类加载的条件，相似的还有@ConditionalOnBean等等
 */
@Component
@ConfigurationProperties(prefix = "user")
@Data
public class UserConfig {

//    @Value("${user.user-name}")
    private String userName;

    private String sex;

//    @JsonIgnore
    //添加该注释，不会被序列化
//    @JsonFormat
    //格式化，一般用于时间
    private String age;

    @JsonSerialize(using = DateSerializer.class)
    private Date birthDay;

}
