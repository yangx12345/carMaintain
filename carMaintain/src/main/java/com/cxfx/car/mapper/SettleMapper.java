package com.cxfx.car.mapper;

import com.cxfx.car.entity.Settle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SettleMapper extends BaseMapper<Settle> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Settle> getListByCondition(Settle condition);

}
