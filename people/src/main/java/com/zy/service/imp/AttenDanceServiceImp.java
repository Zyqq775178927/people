package com.zy.service.imp;

import com.zy.controller.AttenDanceController;
import com.zy.dao.AttenDanceMapper;
import com.zy.model.ATTENDANCE;
import com.zy.model.DESERT;
import com.zy.model.EMP;
import com.zy.service.AttenDanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/3.
 */
@Service
public class AttenDanceServiceImp implements AttenDanceService{
    @Resource
    private AttenDanceMapper attenDanceMapper;

    @Override
    public ATTENDANCE getAttenDanceTime(ATTENDANCE attendance) {
        return attenDanceMapper.getAttenDanceTimeDao(attendance);
    }

    @Override
    public boolean addStartTime(ATTENDANCE attendance) {
        return attenDanceMapper.addStartTime(attendance);
    }

    @Override
    public boolean updateEndTime(ATTENDANCE attendance) {
        return attenDanceMapper.updateEndTimeDao(attendance);
    }

    @Override
    public ATTENDANCE getAttenDance(ATTENDANCE attendance) {
        return attenDanceMapper.getAttenDanceDao(attendance);
    }

    @Override
    public boolean addDesert(DESERT desert) {
        return attenDanceMapper.addDesertDao(desert);
    }

    @Override
    public boolean updateAttenDanceState(ATTENDANCE attendance) {
        return attenDanceMapper.updateAttenDanceStateDao(attendance);
    }

    @Override
    public ATTENDANCE getEndTimt(EMP emp, String data) {
        return attenDanceMapper.getEndTime(emp,data);
    }

    @Override
    public boolean updateDesert(DESERT desert) {
        return attenDanceMapper.updateDesert(desert);
    }

    @Override
    public boolean deleteDesert(DESERT desert) {
        return attenDanceMapper.deleteDesertDao(desert);
    }

    @Override
    public boolean updateAttenDanceEndTime(ATTENDANCE endTimt) {
        return attenDanceMapper.updateAttenDanceEndTime(endTimt);
    }
}
