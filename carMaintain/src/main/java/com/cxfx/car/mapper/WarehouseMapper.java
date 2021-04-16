package com.cxfx.car.mapper;

import com.cxfx.car.entity.Warehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Warehouse> getListByCondition(Warehouse condition);

}
