package com.cxfx.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 角色 0系统管理员 1接待员 2技工
     */
    @TableField("role")
    private String role;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 员工部门Id
     */
    @TableField("departId")
    private Integer departId;

    /**
     * 性别 0男 1女
     */
    @TableField("gender")
    private String gender;

    /**
     * 生日
     */
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱地址
     */
    @TableField("email")
    private String email;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 身份证号码
     */
    @TableField("idcard")
    private String idcard;

    /**
     * 员工工号
     */
    @TableField("work_id")
    private String workId;

    /**
     * 工作状态 0正常 1已出工
     */
    @TableField("workstatus")
    private String workstatus;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
