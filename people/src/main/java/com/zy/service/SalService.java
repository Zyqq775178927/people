package com.zy.service;

import com.zy.model.DESERT;
import com.zy.model.EMP;

import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */
public interface SalService {
    List<EMP> getEmp(int state);

    int getAttenCountDay(EMP emp, int state, String firstDay, String lastDay);//查看员工上个月出勤的天数

    List<DESERT> getDesert(EMP emp, String firstDay, String lastDay);
}
