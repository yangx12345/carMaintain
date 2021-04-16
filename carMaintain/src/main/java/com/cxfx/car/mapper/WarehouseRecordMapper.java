package com.cxfx.car.mapper;

import com.cxfx.car.entity.WarehouseRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseRecordMapper extends BaseMapper<WarehouseRecord> {

    /**
     * 根据查询条件查询实体列表
     */
    List<WarehouseRecord> getListByCondition(WarehouseRecord condition);

}
