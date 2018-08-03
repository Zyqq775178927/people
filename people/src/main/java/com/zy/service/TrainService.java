package com.zy.service;

import com.zy.model.EMP;
import com.zy.model.TRAIN;

import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
public interface TrainService {
    List<EMP> getEmpID(Integer depart);

    boolean addTrain(TRAIN train);

    boolean addEmpAndTrain(int t_id, int e_id);

    List<EMP> getEmps(Integer depart);

    List<EMP> getEmpPositon(Integer depart, Integer position);

    List<TRAIN> getTrain();

    List<TRAIN> getTrainLimit(int currentPage, int pages);

    boolean updateTrain(TRAIN train);

    boolean updateTrainState(TRAIN train);

    TRAIN getTrainID(int t_id);
}
