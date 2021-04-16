package com.cxfx.car.service.impl;

import com.cxfx.car.entity.Performance;
import com.cxfx.car.mapper.PerformanceMapper;
import com.cxfx.car.service.PerformanceService;
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
public class PerformanceServiceImpl extends ServiceImpl<PerformanceMapper, Performance>implements PerformanceService {

    @Override
    public Performance getEntityById(Integer id){
        return this.getById(id);
    }

    @Override
    public List<Performance>getListByCondition(Performance condition){
		return baseMapper.getListByCondition(condition);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean saveEntity(Performance entity){
        return this.save(entity);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean updateEntity(Performance entity){
        return this.updateById(entity);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean deleteById(Integer id){
        return this.removeById(id);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean deleteByIds(String ids){
        Integer[]Ids=Convert.toIntArray(ids);
        List<Integer>idList=Arrays.asList(Ids);
        return this.removeByIds(idList);
    }
}
