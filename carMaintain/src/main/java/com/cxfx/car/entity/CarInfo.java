package com.cxfx.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("car_info")
public class CarInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 车辆编号
     */
    @TableId(value = "car_id", type = IdType.AUTO)
    private Integer carId;

    /**
     * 客户编号
     */
    @TableField("customer_id")
    private Integer customerId;

    /**
     * 车辆编码(车厂区分车辆的编码)
     */
    @TableField("car_code")
    private String carCode;

    /**
     * 客户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 车牌号
     */
    @TableField("car_number")
    private String carNumber;

    /**
     * 车型
     */
    @TableField("car_model")
    private String carModel;

    /**
     * 车类型
     */
    @TableField("car_type")
    private String carType;

    /**
     * 车品牌
     */
    @TableField("car_brand")
    private String carBrand;

    /**
     * 发动机号码
     */
    @TableField("engine_number")
    private String engineNumber;

    /**
     * 底牌号码
     */
    @TableField("chassis_number")
    private String chassisNumber;

    /**
     * 使用单位
     */
    @TableField("use_unit")
    private String useUnit;

    /**
     * 责任人
     */
    @TableField("duty_person")
    private String dutyPerson;

    /**
     * 最近保养时间
     */
    @TableField("maintain_time")
    private LocalDateTime maintainTime;

    /**
     * 录入时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
