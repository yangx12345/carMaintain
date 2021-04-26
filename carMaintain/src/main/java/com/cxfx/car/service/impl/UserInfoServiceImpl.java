package com.cxfx.car.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxfx.car.common.utils.StringUtils;
import com.cxfx.car.entity.UserInfo;
import com.cxfx.car.mapper.UserInfoMapper;
import com.cxfx.car.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.convert.Convert;



import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>implements UserInfoService {

    @Override
    public UserInfo getEntityById(Integer id){
        return this.getById(id);
    }

    @Override
    public List<UserInfo>getListByCondition(UserInfo condition){
		return baseMapper.getListByCondition(condition);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean saveEntity(UserInfo entity){
        return this.save(entity);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean updateEntity(UserInfo entity){
        return this.updateById(entity);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean deleteById(Integer id){
        return this.removeById(id);
    }

    @Override
    public UserInfo getUserInfoByUserId(Integer userId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_id","username","name","role","work_id").eq("user_id",userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public UserInfo getByUsernameAndPassword(String username, String password) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_id","username","role","work_id").eq("username",username).eq("password", SecureUtil.md5(password));
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean deleteByIds(String ids){
        Integer[]Ids=Convert.toIntArray(ids);
        List<Integer>idList=Arrays.asList(Ids);
        return this.removeByIds(idList);
    }

    //根据用户名获取密码
    @Override
    public String getPasswordByUserName(String userName)
    {
        if (StringUtils.isEmpty(userName))
        {
            return "";
        }
        return baseMapper.getPasswordByUserName(userName);
    }
}
