package com.yxxx.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.yxxx.demo.common.result.Result;
import com.yxxx.demo.common.result.ResultUtil;
import com.yxxx.demo.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import com.yxxx.demo.service.SalaryService;
import com.yxxx.demo.entity.Salary;

@Slf4j
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id)
    {
        if(id==null)
        {
            return ResultUtil.parameterError();
        }
        return ResultUtil.success(salaryService.getEntityById(id));
    }

    @PostMapping("getListByCondition")
    public Result getListByCondition(@RequestBody Salary condition,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize)
    {
        if(condition==null || pageIndex==null || pageIndex< 1||pageSize==null||pageSize< 1){
		 return ResultUtil.parameterError();
        }
		PageHelper.startPage(pageIndex, pageSize);
        List<Salary> list= salaryService.getListByCondition(condition);
		PageInfo<Salary> result = new PageInfo<>(list);
        return ResultUtil.success(result);
    }

    @PostMapping("add")
    public Result add(@RequestBody Salary entity)
    {
        if(entity==null){
		return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(salaryService.saveEntity(entity));
    }


    @PutMapping("update")
    public Result update(@RequestBody Salary entity)
    {
        if(entity==null){
		return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(salaryService.updateEntity(entity));
    }


    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id)
    {
        if(id==null){
		 return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(salaryService.deleteById(id));
    }

    @DeleteMapping("batchDelete")
    public Result batchDelete(@RequestParam String ids)
    {
        if(StringUtils.isBlank(ids))
        {
		  return ResultUtil.parameterError();
        }
        return ResultUtil.judgmentResult(salaryService.deleteByIds(ids));
    }
}

