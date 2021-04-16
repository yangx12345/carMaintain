package com.cxfx.car.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warehouse")
public class Warehouse implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 仓库管理编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 型号
     */
    @TableField("model")
    private String model;

    /**
     * 剩余数量
     */
    @TableField("number")
    private Integer number;

    /**
     * 商品描述
     */
    @TableField("description")
    private String description;

    /**
     * 商品价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
