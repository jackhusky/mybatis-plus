package com.zh.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhanghao
 * @date 2020/7/3 - 9:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 自动填充功能
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // 乐观锁
    @Version
    private Integer version;

    // 逻辑删除
    @TableLogic
    private Integer deleted;
}
