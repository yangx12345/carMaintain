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
@TableName("factory")
public class Factory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 出入厂记录编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 客户编号
     */
    @TableField("costomer_id")
    private Integer costomerId;

    /**
     * 客户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 车辆状态 0待入厂1已入场2已出厂
     */
    @TableField("status")
    private String status;

    /**
     * 入厂时间
     */
    @TableField("in_time")
    private LocalDateTime inTime;

    /**
     * 出厂时间
     */
    @TableField("out_time")
    private LocalDateTime outTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
