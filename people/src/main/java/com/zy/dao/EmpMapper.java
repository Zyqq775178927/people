package com.zy.dao;

import com.zy.model.EMP;
import com.zy.model.EMP_TRAIN;
import com.zy.model.T_POSITON;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Repository
public interface EmpMapper {
    Boolean addEmpDao(EMP emp);

    EMP getEmpNameDao(String name);


    List<EMP> getEmp(@Param("did") Integer d_id, @Param("state") Integer e_state);

    List<EMP> getEmpLimit(@Param("did") Integer d_id, @Param("c") int currentPages1, @Param("p") int pages1,@Param("state") Integer e_state);

    List<EMP> getEmpLimitPositon(@Param("did")Integer d_id, @Param("c")int currentPages1,@Param("p") int pages1, @Param("state")Integer e_state, @Param("positon") Integer position);

    EMP empLogin(EMP emp);

    List<EMP_TRAIN> getEmpAndTrain(EMP emp);

    List<EMP_TRAIN> getEmpAndTrainLimit(@Param("emp") EMP emp, @Param("p") int pages1, @Param("c") int currentPages1);
}
