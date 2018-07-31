package com.zy.service;

import com.zy.model.EMP;
import com.zy.model.T_POSITON;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */

public interface PositonService {
    T_POSITON getPositonName(String name,int did);

    boolean addPositons(T_POSITON t_positon);

    List<T_POSITON> getPositons();

    List<T_POSITON> getPositonsLimit(int currentPage, int pages);

    T_POSITON getPositonNames(int did, int pid, String name);

    boolean updatePositon(T_POSITON t_positon);

    List<EMP> getEmps(int pid);

    boolean deletePositon(int pid);
}
