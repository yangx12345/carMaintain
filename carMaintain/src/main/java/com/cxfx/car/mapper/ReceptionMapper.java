package com.cxfx.car.mapper;

import com.cxfx.car.entity.Reception;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceptionMapper extends BaseMapper<Reception> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Reception> getListByCondition(Reception condition);

}
