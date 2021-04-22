package com.cxfx.car.mapper;

import com.cxfx.car.entity.MaintainOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaintainOrderMapper extends BaseMapper<MaintainOrder> {

    /**
     * 根据查询条件查询实体列表
     */
    List<MaintainOrder> getListByCondition(MaintainOrder condition);

}
