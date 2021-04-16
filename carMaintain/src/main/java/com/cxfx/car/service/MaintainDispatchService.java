package com.cxfx.car.service;

import com.cxfx.car.entity.MaintainDispatch;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface MaintainDispatchService extends IService<MaintainDispatch> {

    /**
     * 根据id查询实体
     */
    public MaintainDispatch getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<MaintainDispatch> getListByCondition(MaintainDispatch condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(MaintainDispatch entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(MaintainDispatch entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
