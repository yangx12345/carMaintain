package com.cxfx.car.service;

import com.cxfx.car.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface DepartmentService extends IService<Department> {

    /**
     * 根据id查询实体
     */
    public Department getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<Department> getListByCondition(Department condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(Department entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(Department entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

}
