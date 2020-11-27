package com.example.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/11/25 14:59</br>
 * @since JDK 1.8
 */
@Data
@Table(name = "demo_user")
public class DemoUser {

    @Id
    private String id;

    @Column(name = "user_name")
    private String userName;

    private String sex;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8"
    )
    private Date birthday;
}
