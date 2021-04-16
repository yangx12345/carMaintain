package com.cxfx.car.service;

import com.cxfx.car.entity.Performance;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface PerformanceService extends IService<Performance> {

    /**
     * 根据id查询实体
     */
    public Performance getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<Performance> getListByCondition(Performance condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(Performance entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(Performance entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
