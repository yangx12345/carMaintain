package com.cxfx.car.mapper;

import com.cxfx.car.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Department> getListByCondition(Department condition);

}
