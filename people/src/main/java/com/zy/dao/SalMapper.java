package com.zy.dao;

import com.zy.model.DESERT;
import com.zy.model.EMP;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */
@Repository
public interface SalMapper {
    List<EMP> getEmpDao(int state);

    int getAttenCountDayDao(@Param("emp") EMP emp, @Param("state") int state, @Param("firstDay") String firstDay, @Param("lastDay") String lastDay);

    List<DESERT> getDesertDao(@Param("emp") EMP emp, @Param("firstDay") String firstDay, @Param("lastDay") String lastDay);

}
