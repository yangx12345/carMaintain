package com.cxfx.car.mapper;

import com.cxfx.car.entity.CarInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarInfoMapper extends BaseMapper<CarInfo> {

    /**
     * 根据查询条件查询实体列表
     */
    List<CarInfo> getListByCondition(CarInfo condition);

}
