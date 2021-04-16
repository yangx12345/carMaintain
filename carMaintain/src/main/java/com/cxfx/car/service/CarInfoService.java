package com.cxfx.car.service;

import com.cxfx.car.entity.CarInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface CarInfoService extends IService<CarInfo> {

    /**
     * 根据id查询实体
     */
    public CarInfo getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<CarInfo> getListByCondition(CarInfo condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(CarInfo entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(CarInfo entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
