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
@TableName("warehouse_record")
public class WarehouseRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 出入库记录编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作员编号
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 操作员工号
     */
    @TableField("work_id")
    private String workId;

    /**
     * 操作员姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 商品编号
     */
    @TableField("warehouse_id")
    private Integer warehouseId;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 状态 0入库 1出库
     */
    @TableField("status")
    private String status;

    /**
     * 出入库时间
     */
    @TableField("time")
    private LocalDateTime time;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
