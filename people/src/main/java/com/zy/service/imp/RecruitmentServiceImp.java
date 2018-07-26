package com.zy.service.imp;

import com.zy.dao.RecruitmentMapper;
import com.zy.model.T_RECRUITMENT;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
@Service
public class RecruitmentServiceImp implements RecruitmentService {
    @Resource
    private RecruitmentMapper recruitmentMapper;

    @Override
    public List<T_RECRUITMENT> getRecruitment(int state) {
        return recruitmentMapper.getRecruitmentDao(state);
    }

    @Override
    public List<T_RECRUITMENT> getRecruitmentLimit(int state, int currentPage, int pages) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return recruitmentMapper.getRecruitmentLimitDao(state,pages1,currentPages1);
    }
}
