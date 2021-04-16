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
@TableName("maintain_project")
public class MaintainProject implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 保养项目编号
     */
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    /**
     * 保养项目名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 项目描述
     */
    @TableField("description")
    private String description;

    /**
     * 保养价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 预定定金
     */
    @TableField("order_price")
    private BigDecimal orderPrice;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
