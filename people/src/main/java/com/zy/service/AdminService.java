package com.zy.service;

import com.zy.model.INVITED;
import com.zy.model.R_R;
import com.zy.model.T_ADMIN;
import com.zy.model.T_RESUME;

import java.util.List;

/**
 * Created by Administrator on 2018/7/27.
 */
public interface AdminService {
    T_ADMIN getAdmin(T_ADMIN t_admin);
    boolean addAdmin(T_ADMIN t_admin);

    boolean removeRecruit(int id);

    List<R_R> getR_R();

    T_RESUME adminGetResume(int rb_id);

    boolean updateR_R(int state, int r_id);

    boolean addInvited(INVITED invited);

    List<INVITED> getInvited();

    boolean updateRecruitState(int id, int state);

    boolean addRecruitTime(String time,int id);
}
