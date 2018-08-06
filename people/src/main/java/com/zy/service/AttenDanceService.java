package com.zy.service;


import com.zy.model.ATTENDANCE;
import com.zy.model.DESERT;
import com.zy.model.EMP;

/**
 * Created by Administrator on 2018/8/3.
 */
public interface AttenDanceService{
    ATTENDANCE getAttenDanceTime(ATTENDANCE attendance);

    boolean addStartTime(ATTENDANCE attendance);

    boolean updateEndTime(ATTENDANCE attendance);

    ATTENDANCE getAttenDance(ATTENDANCE attendance);

    boolean addDesert(DESERT desert);

    boolean updateAttenDanceState(ATTENDANCE attendance);

    ATTENDANCE getEndTimt(EMP emp, String data);

    boolean updateDesert(DESERT desert);

    boolean deleteDesert(DESERT desert);

    boolean updateAttenDanceEndTime(ATTENDANCE endTimt);
}
