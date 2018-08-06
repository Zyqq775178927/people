package com.zy.controller;

import com.zy.model.DESERT;
import com.zy.model.EMP;
import com.zy.myutil.Time;
import com.zy.service.SalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */
@Controller
public class SalController {
    @Resource
    private SalService salService;
    @RequestMapping("/salMain")
    public String salMain(){
        return "admin/sal/SalMain";
    }
    @RequestMapping("/settlementSal")
    public String settlementSal(){
        //获取上个月第一天和最后一天
        String firstDay=Time.firstDay();
        String lastDay=Time.lastDay();
        //查看所有在职员工
        int state=0;
        List<EMP> emps=salService.getEmp(state);
        for (int i=0;i<emps.size();i++){
            //先去考勤表查看员工的出勤天数
            int countDay = salService.getAttenCountDay(emps.get(i), state, firstDay, lastDay);
            double money=0; //旷工扣的钱
            int day=22-countDay;
            if (day>0){
                money=200*day;//每旷工一天基本工资扣200；
            }
            //基本工资=基本工资-旷工天数*罚款数目
            double s_basesalary=emps.get(i).getT_positon().getP_sal()-money;
            //查看员工的惩罚记录
            List<DESERT> deserts=salService.getDesert(emps.get(i),firstDay,lastDay);
            double s_rewards=0;//奖惩总金额
            for (int j=0;j<deserts.size();j++){
                s_rewards+=deserts.get(i).getDe_money();
            }
            double s_soctal=emps.get(i).getT_positon().getP_sal()*0.07;//社保

        }
        return null;
    }
}
