package com.zy.service.imp;

import com.zy.dao.SalMapper;
import com.zy.model.DESERT;
import com.zy.model.EMP;
import com.zy.service.SalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */
@Service
public class SalServiceImp implements SalService{
    @Resource
    private SalMapper salMapper;

    @Override
    public List<EMP> getEmp(int state) {
        return salMapper.getEmpDao(state);
    }

    @Override
    public int getAttenCountDay(EMP emp, int state, String firstDay, String lastDay) {
        return salMapper.getAttenCountDayDao(emp,state,firstDay,lastDay);
    }

    @Override
    public List<DESERT> getDesert(EMP emp, String firstDay, String lastDay) {
        return salMapper.getDesertDao(emp,firstDay,lastDay);
    }
}
