package com.cxfx.car.service;

import com.cxfx.car.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface UserInfoService extends IService<UserInfo> {

    /**
     * 根据id查询实体
     */
    public UserInfo getEntityById(Integer id);

    /**
     * 根据条件查询实体列表
     */
    public List<UserInfo> getListByCondition(UserInfo condition);

    /**
     *  保存实体
     */
    public boolean saveEntity(UserInfo entity);

    /**
     *  更新实体
     */
    public boolean updateEntity(UserInfo entity);

    /**
     *  根据id删除实体
     */
    public boolean deleteById(Integer id);

    /**
     *  根据id列表删除
     */
    public boolean deleteByIds(String ids);

	UserInfo getByUsernameAndPassword(String username, String password);

    UserInfo getUserInfoByUserId(Integer userId);
}
