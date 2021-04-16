package com.cxfx.car.mapper;

import com.cxfx.car.entity.MaintainProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaintainProjectMapper extends BaseMapper<MaintainProject> {

    /**
     * 根据查询条件查询实体列表
     */
    List<MaintainProject> getListByCondition(MaintainProject condition);

}
