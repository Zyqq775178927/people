package com.zy.service.imp;

import com.zy.controller.Depart;
import com.zy.dao.DepartMapper;
import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.service.DepartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Service
public class DepartServiceImp implements DepartService {
    @Resource
    private DepartMapper departMapper;

    @Override
    public T_DEPARTMENT getDepartName(String name) {
        return departMapper.getDepartNameDao(name);
    }

    @Override
    public boolean addDeparts(T_DEPARTMENT t_department) {
        return  departMapper.addDepartsDao(t_department);
    }

    @Override
    public List<T_DEPARTMENT> getDepartLimit(int currentPage, int pages) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return departMapper.getDepartLimitDao(currentPages1,pages1);
    }

    @Override
    public boolean updateDepart(T_DEPARTMENT t_department) {
        return departMapper.updateDepartDao(t_department);
    }

    @Override
    public List<T_POSITON> getPositonID(int did) {
        return departMapper.getPositonIDDao(did);
    }

    @Override
    public boolean removeDepart(int did) {
        return departMapper.deleteDepartDao(did);
    }

    @Override
    public List<EMP> getEmpID(List<T_POSITON> t_positons) {
        return departMapper.getEmpDao(t_positons);
    }

    @Override
    public boolean removePositon(List<T_POSITON> t_positons) {
        return departMapper.deletePositon(t_positons);
    }
}
