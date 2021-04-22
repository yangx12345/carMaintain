package com.cxfx.car.entity;

import java.math.BigDecimal;
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
@TableName("maintain_order")
public class MaintainOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单编号
     */
    @TableId(value = "order_id", type = IdType.AUTO)
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
     * 保养项目编号
     */
    @TableField("project_id")
    private Integer projectId;

    /**
     * 保养项目名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 预付定金
     */
    @TableField("order_price")
    private BigDecimal orderPrice;

    /**
     * 保养费用
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 订单状态  1已发起(已支付定金)2进行中3已完成 4已取消
     */
    @TableField("status")
    private String status;

    /**
     * 到店保养时间
     */
    @TableField("maintain_time")
    private LocalDateTime maintainTime;

    /**
     * 预定时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
