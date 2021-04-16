package com.cxfx.car.mapper;

import com.cxfx.car.entity.CustomerInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

    /**
     * 根据查询条件查询实体列表
     */
    List<CustomerInfo> getListByCondition(CustomerInfo condition);

}
