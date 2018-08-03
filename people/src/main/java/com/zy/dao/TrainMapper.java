package com.zy.dao;

import com.zy.model.EMP;
import com.zy.model.TRAIN;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@Repository
public interface TrainMapper {
    List<EMP> getEmpIDDao(Integer depart);

    boolean addTrainDao(TRAIN train);

    boolean addEmpAndTrainDao(@Param("t_id") int t_id,@Param("e_id") int e_id);

    List<EMP> getEmpsDao(Integer depart);

    List<EMP> getEmpPositonDao(@Param("did") Integer depart, @Param("pid") Integer position);

    List<TRAIN> getTrainDao();

    List<TRAIN> getTrainLimitDao(@Param("p") int pages1, @Param("c") int currentPages1);

    boolean updateTrain(TRAIN train);

    boolean updateTrainState(TRAIN train);

    TRAIN getTrainIDDao(int t_id);
}
