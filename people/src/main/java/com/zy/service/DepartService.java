package com.zy.service;

import com.zy.controller.Depart;
import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
public interface DepartService {
    T_DEPARTMENT getDepartName(String name);

    boolean addDeparts(T_DEPARTMENT t_department);

    List<T_DEPARTMENT> getDepartLimit(int currentPage, int pages);

    boolean updateDepart(T_DEPARTMENT t_department);

    List<T_POSITON> getPositonID(int did);

    boolean removeDepart(int did);

    List<EMP> getEmpID(List<T_POSITON> t_positons);

    boolean removePositon(List<T_POSITON> t_positons);
}
