package com.cxfx.car.mapper;

import com.cxfx.car.entity.Performance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PerformanceMapper extends BaseMapper<Performance> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Performance> getListByCondition(Performance condition);

}
