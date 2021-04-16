package com.cxfx.car.mapper;

import com.cxfx.car.entity.Factory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FactoryMapper extends BaseMapper<Factory> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Factory> getListByCondition(Factory condition);

}
