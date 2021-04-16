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
@TableName("reception")
public class Reception implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 接待编号
     */
    @TableId(value = "reception_id", type = IdType.AUTO)
    private Integer receptionId;

    /**
     * 接待员编号
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 接待员工号
     */
    @TableField("work_id")
    private String workId;

    /**
     * 接待员姓名
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
     * 客户姓名
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 接待时间
     */
    @TableField("reception_time")
    private LocalDateTime receptionTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
