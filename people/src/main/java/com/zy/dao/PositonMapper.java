package com.zy.dao;

import com.zy.model.EMP;
import com.zy.model.T_POSITON;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@Repository
public interface PositonMapper {
    T_POSITON getPositonNameDao(@Param("name") String name,@Param("did") int did);

    boolean addPositonsDao(T_POSITON t_positon);

    List<T_POSITON> getPositonsDao();

    List<T_POSITON> getPositonsLimitDao(@Param("p") int pages1, @Param("c") int currentPages1);

    T_POSITON getPositonNames(@Param("did") int did, @Param("pid") int pid, @Param("name") String name);

    boolean updatePositonDao(T_POSITON t_positon);

    List<EMP> getEmpDao(int pid);

    boolean deletePositon(int pid);
}
