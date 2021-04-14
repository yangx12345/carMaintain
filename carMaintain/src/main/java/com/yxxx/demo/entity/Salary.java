package com.yxxx.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangxiao
 * @since 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("salary")
public class Salary implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 基本工资
     */
    @TableField("basicSalary")
    private Integer basicSalary;

    /**
     * 奖金
     */
    @TableField("bonus")
    private Integer bonus;

    /**
     * 午餐补助
     */
    @TableField("lunchSalary")
    private Integer lunchSalary;

    /**
     * 交通补助
     */
    @TableField("trafficSalary")
    private Integer trafficSalary;

    /**
     * 应发工资
     */
    @TableField("allSalary")
    private Integer allSalary;

    /**
     * 养老金基数
     */
    @TableField("pensionBase")
    private Integer pensionBase;

    /**
     * 养老金比率
     */
    @TableField("pensionPer")
    private Float pensionPer;

    /**
     * 启用时间
     */
    @TableField("createDate")
    private Date createDate;

    /**
     * 医疗基数
     */
    @TableField("medicalBase")
    private Integer medicalBase;

    /**
     * 医疗保险比率
     */
    @TableField("medicalPer")
    private Float medicalPer;

    /**
     * 公积金基数
     */
    @TableField("accumulationFundBase")
    private Integer accumulationFundBase;

    /**
     * 公积金比率
     */
    @TableField("accumulationFundPer")
    private Float accumulationFundPer;

    @TableField("name")
    private String name;


}
