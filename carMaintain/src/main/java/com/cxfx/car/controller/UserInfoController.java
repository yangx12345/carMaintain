package com.cxfx.car.controller;


import cn.hutool.crypto.SecureUtil;
import com.cxfx.car.common.utils.JwtUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cxfx.car.common.result.Result;
import com.cxfx.car.common.result.ResultUtil;
import com.cxfx.car.common.utils.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cxfx.car.service.UserInfoService;
import com.cxfx.car.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
    * 根据id查询实体
    */
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id)
    {
        if(id==null)
        {
            return ResultUtil.parameterError();
        }
        return ResultUtil.success(userInfoService.getEntityById(id));
    }

    /**
    * 根据条件查询实体列表
    */
    @PostMapping("getListByCondition")
    public Result getListByCondition(@RequestBody UserInfo condition,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize)
    {
        if(condition==null || pageIndex==null || pageIndex< 1||pageSize==null||pageSize< 1){
		 return ResultUtil.parameterError();
        }
		PageHelper.startPage(pageIndex, pageSize);
        List<UserInfo> list= userInfoService.getListByCondition(condition);
		PageInfo<UserInfo> result = new PageInfo<>(list);
        return ResultUtil.success(result);
    }

    /**
    * 增加实体
    */
    @PostMapping("add")
    public Result add(@RequestBody UserInfo entity)
    {
        if(entity==null){
		return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(userInfoService.saveEntity(entity));
    }


    /**
    * 更新实体
    */
    @PutMapping("update")
    public Result update(@RequestBody UserInfo entity)
    {
        if(entity==null){
		return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(userInfoService.updateEntity(entity));
    }


    /**
    * 根据id删除
    */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id)
    {
        if(id==null){
		 return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(userInfoService.deleteById(id));
    }

    /**
    * 根据id列表批量删除
    */
    @DeleteMapping("batchDelete")
    public Result batchDelete(@RequestParam String ids)
    {
        if(StringUtils.isBlank(ids))
        {
		  return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(userInfoService.deleteByIds(ids));
    }

    /**
     *
     * 用户登录
     *
     * @date 2021-04-16 13:19
     * @param user 登录信息
     * @return com.ddys.gemsell.common.result.Result 返回结果
     **/
    @PostMapping("login")
    public Result login(@RequestBody UserInfo user)
    {
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
        {
            return ResultUtil.parameterError();
        }
        UserInfo findUser  =  userInfoService.getByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (findUser == null)
        {
            return ResultUtil.error("账号密码错误或用户不存在");
        }
        Map<String,String> claimMap = new HashMap<>(4);
        claimMap.put("role",findUser.getRole());
        claimMap.put("userId",findUser.getUserId().toString());
        claimMap.put("userName",findUser.getUsername());
        String token = JwtUtils.sign(claimMap, SecureUtil.md5(user.getPassword()),null);
        return ResultUtil.success("登录成功",token);
    }

    @PostMapping("getUserInfoByToken")
    public Result getUserInfoByToken(HttpServletRequest request)
    {
        String token = request.getHeader("token");
        Integer userId = Integer.valueOf(JwtUtils.getClaimValueByToken(token,"userId"));
        return ResultUtil.success(userInfoService.getUserInfoByUserId(userId));
    }
}

