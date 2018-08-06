package com.zy.service;

import com.zy.model.EMP;
import com.zy.model.EMP_TRAIN;
import com.zy.model.T_POSITON;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
public interface EmpService {
    Boolean addEmp(EMP emp);

    EMP getEmpName(String name);

    List<EMP> getEmp(@Param("did") Integer d_id, @Param("state") Integer e_state);

    List<EMP> getEmpLimits(Integer d_id, int currentPage, int pages, Integer e_state);

    List<EMP> getEmpLimit(Integer d_id, int currentPage, int pages, Integer e_state, Integer position);

    EMP empLogin(EMP emp);

    List<EMP_TRAIN> getEmpAndTrain(EMP emp);

    List<EMP_TRAIN> getEmpAndTrainLimit(EMP emp, int currentPage, int pages);
}
