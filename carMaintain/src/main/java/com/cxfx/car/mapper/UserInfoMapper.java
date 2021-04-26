package com.cxfx.car.mapper;

import com.cxfx.car.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 根据查询条件查询实体列表
     */
    List<UserInfo> getListByCondition(UserInfo condition);

	/**
	 * 根据用户名获取密码
	 */
	String getPasswordByUserName(String userName);
}
