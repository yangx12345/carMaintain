package com.cxfx.car.service;

import com.cxfx.car.entity.MaintainProject;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface MaintainProjectService extends IService<MaintainProject> {

    /**
     * 根据id查询实体
     */
    public MaintainProject getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<MaintainProject> getListByCondition(MaintainProject condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(MaintainProject entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(MaintainProject entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
