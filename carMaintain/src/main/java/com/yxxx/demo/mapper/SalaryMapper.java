package com.yxxx.demo.mapper;

import com.yxxx.demo.entity.Salary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangxiao
 * @since 2021-03-12
 */
public interface SalaryMapper extends BaseMapper<Salary> {

    /**
     * 根据查询条件查询实体列表
     */
    List<Salary> getListByCondition(Salary condition);

}
