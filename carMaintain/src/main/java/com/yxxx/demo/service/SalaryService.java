package com.yxxx.demo.service;

import com.yxxx.demo.entity.Salary;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface SalaryService extends IService<Salary> {

    /**
     * 根据id查询实体列表
     */
    public Salary getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<Salary> getListByCondition(Salary condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(Salary entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(Salary entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
