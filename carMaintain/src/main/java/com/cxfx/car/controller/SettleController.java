package com.cxfx.car.controller;


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

import com.cxfx.car.service.SettleService;
import com.cxfx.car.entity.Settle;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/settle")
public class SettleController {
    @Autowired
    private SettleService settleService;

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
        return ResultUtil.success(settleService.getEntityById(id));
    }

    /**
    * 根据条件查询实体列表
    */
    @PostMapping("getListByCondition")
    public Result getListByCondition(@RequestBody Settle condition,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize)
    {
        if(condition==null || pageIndex==null || pageIndex< 1||pageSize==null||pageSize< 1){
		 return ResultUtil.parameterError();
        }
		PageHelper.startPage(pageIndex, pageSize);
        List<Settle> list= settleService.getListByCondition(condition);
		PageInfo<Settle> result = new PageInfo<>(list);
        return ResultUtil.success(result);
    }

    /**
    * 增加实体
    */
    @PostMapping("add")
    public Result add(@RequestBody Settle entity)
    {
        if(entity==null){
		return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(settleService.saveEntity(entity));
    }


    /**
    * 更新实体
    */
    @PutMapping("update")
    public Result update(@RequestBody Settle entity)
    {
        if(entity==null){
		return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(settleService.updateEntity(entity));
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
        return ResultUtil.judgmentResult(settleService.deleteById(id));
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
        return ResultUtil.judgmentResult(settleService.deleteByIds(ids));
    }
}

