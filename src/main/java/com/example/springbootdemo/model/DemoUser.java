package com.example.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
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
