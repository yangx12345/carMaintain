package com.cxfx.car.mapper;

import com.cxfx.car.entity.MaintainDispatch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaintainDispatchMapper extends BaseMapper<MaintainDispatch> {

    /**
     * 根据查询条件查询实体列表
     */
    List<MaintainDispatch> getListByCondition(MaintainDispatch condition);

}
