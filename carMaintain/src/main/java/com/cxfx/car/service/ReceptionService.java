package com.cxfx.car.service;

import com.cxfx.car.entity.Reception;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface ReceptionService extends IService<Reception> {

    /**
     * 根据id查询实体
     */
    public Reception getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<Reception> getListByCondition(Reception condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(Reception entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(Reception entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
