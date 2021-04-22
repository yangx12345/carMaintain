package com.cxfx.car.service;

import com.cxfx.car.entity.MaintainOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface MaintainOrderService extends IService<MaintainOrder> {

    /**
     * 根据id查询实体
     */
    public MaintainOrder getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<MaintainOrder> getListByCondition(MaintainOrder condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(MaintainOrder entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(MaintainOrder entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
