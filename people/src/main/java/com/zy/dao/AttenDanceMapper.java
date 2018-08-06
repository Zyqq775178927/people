package com.zy.dao;

import com.zy.controller.AttenDanceController;
import com.zy.model.ATTENDANCE;
import com.zy.model.DESERT;
import com.zy.model.EMP;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/8/3.
 */
@Repository
public interface AttenDanceMapper {
    ATTENDANCE getAttenDanceTimeDao(ATTENDANCE attendance);

    boolean addStartTime(ATTENDANCE attendance);

    boolean updateEndTimeDao(ATTENDANCE attendance);

    ATTENDANCE getAttenDanceDao(ATTENDANCE attendance);

    boolean addDesertDao(DESERT desert);

    boolean updateAttenDanceStateDao(ATTENDANCE attendance);

    ATTENDANCE getEndTime(@Param("emp") EMP emp,@Param("state") String data);

    boolean updateDesert(DESERT desert);

    boolean deleteDesertDao(DESERT desert);

    boolean updateAttenDanceEndTime(ATTENDANCE endTimt);

}
