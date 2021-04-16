package com.cxfx.car.service;

import com.cxfx.car.entity.Factory;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface FactoryService extends IService<Factory> {

    /**
     * 根据id查询实体
     */
    public Factory getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<Factory> getListByCondition(Factory condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(Factory entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(Factory entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
