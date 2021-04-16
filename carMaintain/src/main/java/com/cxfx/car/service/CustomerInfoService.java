package com.cxfx.car.service;

import com.cxfx.car.entity.CustomerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface CustomerInfoService extends IService<CustomerInfo> {

    /**
     * 根据id查询实体
     */
    public CustomerInfo getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<CustomerInfo> getListByCondition(CustomerInfo condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(CustomerInfo entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(CustomerInfo entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
