package com.zy.dao;

import com.zy.model.EMP;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/7/30.
 */
@Repository
public interface EmpMapper {
    Boolean addEmpDao(EMP emp);

    EMP getEmpNameDao(String name);
}
