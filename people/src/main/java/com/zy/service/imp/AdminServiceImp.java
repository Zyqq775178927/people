package com.zy.service.imp;

import com.zy.dao.AdminMapper;
import com.zy.model.INVITED;
import com.zy.model.R_R;
import com.zy.model.T_ADMIN;
import com.zy.model.T_RESUME;
import com.zy.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/27.
 */
@Service
public class AdminServiceImp implements AdminService{
    @Resource
    private AdminMapper adminMapper;
    @Override
    public T_ADMIN getAdmin(T_ADMIN t_admin) {
        return adminMapper.getAdmin(t_admin);
    }

    @Override
    public boolean addAdmin(T_ADMIN t_admin) {
        return adminMapper.addAdmin(t_admin);
    }

    @Override
    public boolean removeRecruit(int id) {
        return adminMapper.removeRecruitDao(id);
    }

    @Override
    public List<R_R> getR_R() {
        return adminMapper.getR_RDao();
    }

    @Override
    public T_RESUME adminGetResume(int rb_id) {
        return adminMapper.adminGetResume(rb_id);
    }

    @Override
    public boolean updateR_R(int state, int r_id) {
        return adminMapper.updateR_RDao(state,r_id);
    }

    @Override
    public boolean addInvited(INVITED invited) {
        return adminMapper.addInvitedDao(invited);
    }

    @Override
    public List<INVITED> getInvited() {
        return adminMapper.getInvitedDao();
    }
}
