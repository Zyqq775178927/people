package com.zy.service.imp;

import com.zy.dao.TrainMapper;
import com.zy.model.EMP;
import com.zy.model.TRAIN;
import com.zy.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@Service
public class TrainServiceImp implements TrainService{
    @Resource
    private TrainMapper trainMapper;

    @Override
    public List<EMP> getEmpID(Integer depart) {
        return trainMapper.getEmpIDDao(depart);
    }

    @Override
    public boolean addTrain(TRAIN train) {
        return trainMapper.addTrainDao(train);
    }

    @Override
    public boolean addEmpAndTrain(int t_id, int e_id) {
        return trainMapper.addEmpAndTrainDao(t_id,e_id);
    }

    @Override
    public List<EMP> getEmps(Integer depart) {
        //培训部门的
        return trainMapper.getEmpsDao(depart);
    }

    @Override
    public List<EMP> getEmpPositon(Integer depart, Integer position) {
        return trainMapper.getEmpPositonDao(depart,position);
    }

    @Override
    public List<TRAIN> getTrain() {
        return trainMapper.getTrainDao();
    }

    @Override
    public List<TRAIN> getTrainLimit(int currentPage, int pages) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return trainMapper.getTrainLimitDao(pages1,currentPages1);
    }

    @Override
    public boolean updateTrain(TRAIN train) {
        return trainMapper.updateTrain(train);
    }

    @Override
    public boolean updateTrainState(TRAIN train) {
        return trainMapper.updateTrainState(train);
    }

    @Override
    public TRAIN getTrainID(int t_id) {
        return trainMapper.getTrainIDDao(t_id);
    }
}
