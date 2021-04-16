package com.cxfx.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("performance")
public class Performance implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 真实姓名
     */
    @TableField("name")
    private String name;

    /**
     * 员工工号
     */
    @TableField("work_id")
    private String workId;

    /**
     * 早退次数
     */
    @TableField("early_num")
    private Integer earlyNum;

    /**
     * 时间
     */
    @TableField("time")
    private LocalDate time;

    /**
     * 缺勤天数
     */
    @TableField("absenteeism_num")
    private Integer absenteeismNum;

    /**
     * 出勤天数
     */
    @TableField("attendance_num")
    private Integer attendanceNum;

    /**
     * 迟到次数
     */
    @TableField("late_num")
    private Integer lateNum;

    /**
     * 出工次数
     */
    @TableField("work_num")
    private Integer workNum;

    /**
     * 录入人
     */
    @TableField("entry_id")
    private Integer entryId;

    /**
     * 录入日期
     */
    @TableField("entry_date")
    private LocalDateTime entryDate;

    /**
     * 更新人
     */
    @TableField("update_id")
    private Integer updateId;

    /**
     * 更新日期
     */
    @TableField("update_date")
    private LocalDateTime updateDate;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
