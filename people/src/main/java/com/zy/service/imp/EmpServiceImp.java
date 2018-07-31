package com.zy.service.imp;

import com.zy.dao.EmpMapper;
import com.zy.model.EMP;
import com.zy.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
