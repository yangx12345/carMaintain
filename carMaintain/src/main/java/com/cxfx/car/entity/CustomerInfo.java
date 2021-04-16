package com.cxfx.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("customer_info")
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 客户编号
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

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
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 车辆信息编号
     */
    @TableField("car_id")
    private Integer carId;

    /**
     * 车辆编码
     */
    @TableField("car_code")
    private String carCode;

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
     * 录入日期
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
