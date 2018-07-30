package com.zy.dao;

import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.model.T_RECRUITMENT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
public interface RecruitmentMapper {
    List<T_RECRUITMENT> getRecruitmentDao();

    List<T_RECRUITMENT> getRecruitmentLimitDao(@Param("p") int pages1,@Param("c") int currentPages1);

    boolean updateRecuritD(T_RECRUITMENT t_recruitment);

    List<T_DEPARTMENT> getDepartDao();

    List<T_POSITON> getPositonDao(int did);

    boolean addRecruitDao(T_RECRUITMENT t_recruitment);
}
