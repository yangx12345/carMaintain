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
@TableName("settle")
public class Settle implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 结算编号
     */
    @TableId(value = "settle_id", type = IdType.AUTO)
    private Integer settleId;

    /**
     * 结算员编号
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 结算员工号
     */
    @TableField("work_id")
    private String workId;

    /**
     * 结算员姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 客户编号
     */
    @TableField("customer_id")
    private Integer customerId;

    /**
     * 客户名字
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 订单编号
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 保养编号
     */
    @TableField("project_id")
    private Integer projectId;

    /**
     * 保养名字
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 保养价格
     */
    @TableField("project_price")
    private BigDecimal projectPrice;

    /**
     * 商品json [{'id':'','name':'','price':''}]
     */
    @TableField("goods")
    private String goods;

    /**
     * 商品总价格
     */
    @TableField("goods_price")
    private BigDecimal goodsPrice;

    /**
     * 总价格
     */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
     * 结算时间
     */
    @TableField("settle_time")
    private LocalDateTime settleTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
