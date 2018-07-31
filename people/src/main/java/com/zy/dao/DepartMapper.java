package com.zy.dao;

import com.zy.controller.Depart;
import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Repository
public interface DepartMapper {
    T_DEPARTMENT getDepartNameDao(String name);

    boolean addDepartsDao(T_DEPARTMENT t_department);

    List<T_DEPARTMENT> getDepartLimitDao(@Param("c") int currentPages1,@Param("p") int pages1);

    boolean updateDepartDao(T_DEPARTMENT t_department);

    List<T_POSITON> getPositonIDDao(int did);

    boolean deleteDepartDao(int did);

    List<EMP> getEmpDao(List<T_POSITON> t_positons);

    boolean deletePositon(List<T_POSITON> t_positons);
}
