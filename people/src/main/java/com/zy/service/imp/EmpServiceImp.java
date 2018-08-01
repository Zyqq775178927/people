package com.zy.service.imp;

import com.zy.dao.EmpMapper;
import com.zy.model.EMP;
import com.zy.model.T_POSITON;
import com.zy.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Service
public class EmpServiceImp implements EmpService{
    @Resource
    private EmpMapper empMapper;

    @Override
    public Boolean addEmp(EMP emp) {
        return empMapper.addEmpDao(emp);
    }

    @Override
    public EMP getEmpName(String name) {
        return empMapper.getEmpNameDao(name);
    }


    @Override
    public List<EMP> getEmp(Integer d_id, Integer e_state) {
        return empMapper.getEmp(d_id,e_state);
    }

    @Override
    public List<EMP> getEmpLimits(Integer d_id, int currentPage, int pages, Integer e_state) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return empMapper.getEmpLimit(d_id,currentPages1,pages1,e_state);
    }

    @Override
    public List<EMP> getEmpLimit(Integer d_id, int currentPage, int pages, Integer e_state, Integer position) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return empMapper.getEmpLimitPositon(d_id,currentPages1,pages1,e_state,position);
    }
}
