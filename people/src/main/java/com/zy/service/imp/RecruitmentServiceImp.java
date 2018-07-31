package com.zy.service.imp;

import com.zy.dao.RecruitmentMapper;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
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
    public List<T_RECRUITMENT> getRecruitmentLimit( int state,int currentPage, int pages) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return recruitmentMapper.getRecruitmentLimitDao(state,pages1,currentPages1);
    }

    @Override
    public boolean updateRecruit(T_RECRUITMENT t_recruitment) {
        return recruitmentMapper.updateRecuritD(t_recruitment);
    }

    @Override
    public List<T_DEPARTMENT> getDepart() {
        return recruitmentMapper.getDepartDao();
    }

    @Override
    public List<T_POSITON> getPositon(int did) {
        return recruitmentMapper.getPositonDao(did);
    }

    @Override
    public boolean addRecruit(T_RECRUITMENT t_recruitment) {
        return recruitmentMapper.addRecruitDao(t_recruitment);
    }
}
