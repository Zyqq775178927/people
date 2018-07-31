package com.zy.dao;

import com.zy.model.INVITED;
import com.zy.model.R_R;
import com.zy.model.T_ADMIN;
import com.zy.model.T_RESUME;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/27.
 */
public interface AdminMapper {
    T_ADMIN getAdmin(T_ADMIN t_admin);
    boolean addAdmin(T_ADMIN t_admin);

    boolean removeRecruitDao(int id);

    List<R_R> getR_RDao();

    T_RESUME adminGetResume(int rb_id);

    boolean updateR_RDao(@Param("state") int state, @Param("id") int r_id);

    boolean addInvitedDao(INVITED invited);

    List<INVITED> getInvitedDao();

    boolean updateRecruitState(@Param("id") int id, @Param("state") int state);

    boolean updateRecruitTimeDao(@Param("t") String time,@Param("i") int id);

}
