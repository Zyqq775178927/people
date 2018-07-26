package com.zy.service;

import com.zy.model.T_RECRUITMENT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
public interface RecruitmentService {
    List<T_RECRUITMENT> getRecruitment(int state);

    List<T_RECRUITMENT> getRecruitmentLimit(@Param("state") int state, @Param("c") int currentPage, @Param("p") int pages);
}