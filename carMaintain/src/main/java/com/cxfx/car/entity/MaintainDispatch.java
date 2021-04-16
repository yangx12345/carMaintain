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
@TableName("maintain_dispatch")
public class MaintainDispatch implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 派工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 技工编号
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 技工名字
     */
    @TableField("user_name")
    private String userName;

    /**
     * 订单编号
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 客户编号
     */
    @TableField("customer_id")
    private Integer customerId;

    /**
     * 客户名称
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 车辆编号
     */
    @TableField("car_id")
    private Integer carId;

    /**
     * 车辆编码
     */
    @TableField("car_code")
    private String carCode;

    /**
     * 派工时间
     */
    @TableField("time")
    private LocalDateTime time;

    /**
     * 状态 0进行中1已完成
     */
    @TableField("status")
    private String status;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
