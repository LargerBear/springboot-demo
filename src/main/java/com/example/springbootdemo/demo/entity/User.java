package com.example.springbootdemo.demo.entity;
        import com.baomidou.mybatisplus.annotation.TableName;
        import com.baomidou.mybatisplus.annotation.IdType;
        import com.baomidou.mybatisplus.annotation.TableId;
        import com.baomidou.mybatisplus.annotation.TableField;
        import java.io.Serializable;
    import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package: com.example.springbootdemo.demo.entity
 * @Description: <实体>
 * @Author: xz
 * @CreateDate: 2021-11-15
 * @UpdateUser: xz
 * @UpdateDate: 2021-11-15
 * @UpdateRemark: <>
 * @Version: 1.0
 */
@Data
@ApiModel(value = "User实体")
public class User implements Serializable{
/**
 * 序列化时候使用
 */
private static final long serialVersionUID = 1L;

                                @TableId("id")
                                                @ApiModelProperty(value = "", notes = "")
            private Integer id;

                                            @ApiModelProperty(value = "", notes = "")
            private String name;

                                            @ApiModelProperty(value = "", notes = "")
            private String sex;

}
