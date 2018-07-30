package com.zy.service;

import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.model.T_RECRUITMENT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
public interface RecruitmentService {
    List<T_RECRUITMENT> getRecruitment();

    List<T_RECRUITMENT> getRecruitmentLimit( @Param("c") int currentPage, @Param("p") int pages);

    boolean updateRecruit(T_RECRUITMENT t_recruitment);

    List<T_DEPARTMENT> getDepart();

    List<T_POSITON> getPositon(int did);

    boolean addRecruit(T_RECRUITMENT t_recruitment);
}
