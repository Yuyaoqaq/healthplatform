package com.cy.healthplat.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 
 * @TableName easyuser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Easyuser {
    private Integer id;
    private String username;
    private String password;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private String role;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer state;
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)  // 添加时 赋值
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //@TableField(fill = FieldFill.UPDATE)  //修改时 赋值
    @TableField(fill = FieldFill.INSERT_UPDATE)  // 添加 和 修改 都会赋值
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}