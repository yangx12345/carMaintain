package com.cxfx.car.service;

import com.cxfx.car.entity.Warehouse;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface WarehouseService extends IService<Warehouse> {

    /**
     * 根据id查询实体
     */
    public Warehouse getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<Warehouse> getListByCondition(Warehouse condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(Warehouse entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(Warehouse entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
