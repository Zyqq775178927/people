package com.zy.service;

import com.zy.model.EMP;

/**
 * Created by Administrator on 2018/7/30.
 */
public interface EmpService {
    Boolean addEmp(EMP emp);

    EMP getEmpName(String name);
}
