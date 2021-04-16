package com.cxfx.car.service;

import com.cxfx.car.entity.WarehouseRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface WarehouseRecordService extends IService<WarehouseRecord> {

    /**
     * 根据id查询实体
     */
    public WarehouseRecord getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<WarehouseRecord> getListByCondition(WarehouseRecord condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(WarehouseRecord entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(WarehouseRecord entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
