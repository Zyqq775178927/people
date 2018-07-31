package com.zy.service.imp;

import com.zy.dao.PositonMapper;
import com.zy.model.EMP;
import com.zy.model.T_POSITON;
import com.zy.service.PositonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class PositonServiceImp implements PositonService{
    @Resource
    private PositonMapper positonMapper;

    @Override
    public T_POSITON getPositonName(String name,int did) {
        return positonMapper.getPositonNameDao(name,did);
    }

    @Override
    public boolean addPositons(T_POSITON t_positon) {
        return positonMapper.addPositonsDao(t_positon);
    }

    @Override
    public List<T_POSITON> getPositons() {
        return positonMapper.getPositonsDao();
    }

    @Override
    public List<T_POSITON> getPositonsLimit(int currentPage, int pages) {
        int pages1=currentPage*pages;
        int currentPages1=(currentPage-1)*pages;
        return positonMapper.getPositonsLimitDao(pages1,currentPages1);
    }

    @Override
    public T_POSITON getPositonNames(int did, int pid, String name) {
        return positonMapper.getPositonNames(did,pid,name);
    }

    @Override
    public boolean updatePositon(T_POSITON t_positon) {
        return positonMapper.updatePositonDao(t_positon);
    }

    @Override
    public List<EMP> getEmps(int pid) {
        return positonMapper.getEmpDao(pid);
    }

    @Override
    public boolean deletePositon(int pid) {
        return positonMapper.deletePositon(pid);
    }
}
