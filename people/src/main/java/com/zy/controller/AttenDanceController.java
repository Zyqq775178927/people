package com.zy.controller;

import com.zy.model.ATTENDANCE;
import com.zy.model.DESERT;
import com.zy.model.EMP;
import com.zy.myutil.Time;
import com.zy.service.AttenDanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;

/**
 * Created by Administrator on 2018/8/3.
 */
@Controller
public class AttenDanceController {
    @Resource
    private AttenDanceService attenDanceService;
    @RequestMapping("/clockIn")
    public String clockIn(HttpServletRequest request, HttpSession session){
        String time=Time.time2();
        EMP emp= (EMP) session.getAttribute("emp");
        ATTENDANCE attendance=new ATTENDANCE();
        attendance.setEmp(emp);
        attendance.setA_data(time);
        ATTENDANCE attendance1=attenDanceService.getAttenDanceTime(attendance);
        if (attendance1==null||attendance1.getA_starttime()==null){
            request.setAttribute("clock",1);
        }else{
            request.setAttribute("clock",2);
        }
        return "emp/ClockIn";
    }
    @RequestMapping("/goWork")
    public String goWork(HttpSession session){
        EMP emp= (EMP) session.getAttribute("emp");
        String data=Time.time2();
        String starttime=Time.timeHMS();
        ATTENDANCE attendance=new ATTENDANCE();
        attendance.setA_data(data);
        attendance.setA_starttime(starttime);
        attendance.setEmp(emp);
        attenDanceService.addStartTime(attendance);
        return "emp/empMain";
    }
    @RequestMapping("/afterWork")
    public String afterWork(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
        EMP emp= (EMP) session.getAttribute("emp");
        String data=Time.time2();
        String afterWorktime=Time.timeHMS(); //下班时间
        //查出今天的考勤记录
        ATTENDANCE attendance=new ATTENDANCE();
        attendance.setEmp(emp);
        attendance.setA_data(data);
        ATTENDANCE newAttenDance = attenDanceService.getAttenDance(attendance);
        long startTime = Time.startTime9(); //公司固定上班9点的毫秒数
        String a_starttime = newAttenDance.getA_starttime(); //今天上班打卡的时间
        long endTime = Time.startTime6();//公司固定下班时间下午6点
        //将上班打卡时间转换成毫秒
        long userStartTime = Time.startTime2(a_starttime);

        //先查有木有打过下班卡
        ATTENDANCE endTimt = attenDanceService.getEndTimt(emp, data);
        if (endTimt.getA_endtime()==null){ //没有打过下班卡
            //上班打卡情况
            if (userStartTime-startTime>0) {//用户打卡时间超过公司时间说明迟到了
                if (userStartTime-startTime>0&&userStartTime-startTime<=3600000){//迟到一小时扣100
                    //添加一条惩罚记录
                    double money=-50;
                    String de_intro="迟到一小时";
                    int de_state=0;//惩罚
                    DESERT desert=new DESERT(emp,money,de_intro,data,de_state);
                    attenDanceService.addDesert(desert);
                }else if (userStartTime-startTime>3600000&&userStartTime-startTime<=7200000){//扣200
                    //添加一条惩罚记录
                    double money=-100;
                    String de_intro="迟到二小时";
                    int de_state=0;//惩罚
                    DESERT desert=new DESERT(emp,money,de_intro,data,de_state);
                    attenDanceService.addDesert(desert);
                }else {//旷工
                    return "emp/empMain";
                }
            }
            endTimt.setA_endtime(afterWorktime);
            endTimt.setA_state(0);
            endTimt.setEmp(emp);
            attenDanceService.updateEndTime(endTimt);
            //将下班打卡时间换成毫秒
            long userEndTime=Time.startTime2(afterWorktime);
            if (endTime-userEndTime>0){//公司下班时间减掉用户下班时间大于0说明早退了
                if (userEndTime-endTime>7200000){//早退2个小时以上算旷工
                    return "emp/empMain";
                }else if (userEndTime-endTime<=7200000&&userEndTime-endTime>3600000){//早退1小时以上
                    //添加一条惩罚记录
                    double money=-100;
                    String de_intro="早退二小时";
                    int state1=-1;//惩罚
                    DESERT desert=new DESERT(emp,money,de_intro,data,state1);
                    System.out.println(desert);
                    attenDanceService.addDesert(desert);
                    //生成考勤记录
                    newAttenDance.setA_state(1);
                    attenDanceService.updateAttenDanceState(newAttenDance);
                }else {//早退1个小时
                    //添加一条惩罚记录
                    double money=-50;
                    String de_intro="早退一小时";
                    int state1=-1;//惩罚
                    DESERT desert=new DESERT(emp,money,de_intro,data,state1);
                    attenDanceService.addDesert(desert);
                    //生成考勤记录
                    newAttenDance.setA_state(1);
                    attenDanceService.updateAttenDanceState(newAttenDance);
                }
            }else if (endTime-userEndTime==0){//正常下班
                newAttenDance.setA_state(1);
                attenDanceService.updateAttenDanceState(newAttenDance);
            }else {//小于0说明加班了
                if (userEndTime-endTime>7200000){//加班超过2小时给200
                    //添加一条奖励记录
                    double money=100;
                    String de_intro="加班两个小时";
                    int de_state=1;//奖励
                    DESERT desert=new DESERT(emp,money,de_intro,data,de_state);
                    attenDanceService.addDesert(desert);
                    //生成考勤记录
                    newAttenDance.setA_state(1);
                    attenDanceService.updateAttenDanceState(newAttenDance);
                }else if (userEndTime-endTime<=7200000&&userEndTime-endTime>3600000){//加班一个小时
                    //添加一条奖励记录
                    double money=50;
                    String de_intro="加班一个小时";
                    int de_state=1;//奖励
                    DESERT desert=new DESERT(emp,money,de_intro,data,de_state);
                    attenDanceService.addDesert(desert);
                    //生成考勤记录
                    newAttenDance.setA_state(1);
                    attenDanceService.updateAttenDanceState(newAttenDance);
                }else {//一个小时以下不算加班
                    newAttenDance.setA_state(1);
                    attenDanceService.updateAttenDanceState(newAttenDance);
                }
            }
            return "emp/empMain";
        }else {
            String startEndTime=endTimt.getA_endtime();//获得前一次打卡时间
            long s = Time.startTime2(startEndTime);//把前一次的打卡时间转换
            long time=Time.startTime2(afterWorktime); //当前时间
            if (endTime-s>=0){//再次打卡时候如果前面时间少于工资打卡时间还是维持原来的
                return "emp/empMain";
            }else {
                if (endTime-time==0){
                    endTimt.setEmp(emp);
                    endTimt.setA_endtime(afterWorktime);
                    attenDanceService.updateAttenDanceEndTime(endTimt);
                    newAttenDance.setA_state(1);
                    attenDanceService.updateAttenDanceState(newAttenDance);
                }else {//再次打卡超过规定的打卡时间的时候算加班
                    //先将下班早退惩罚删掉
//                DESERT desert=new DESERT();
//                desert.setEmp(emp);
//                int state=-1;
//                desert.setDe_state(state);
//                desert.setDe_time(data);
//                attenDanceService.deleteDesert(desert);
                    //修改时间
                    endTimt.setEmp(emp);
                    endTimt.setA_endtime(afterWorktime);
                    attenDanceService.updateAttenDanceEndTime(endTimt);
                    if (time-endTime>7200000){//加班超过2小时给200
                        //修改加班费用跟加班原因
                        double money=100;
                        String de_intro="加班两个小时";
                        int de_state=1;//奖励
                        DESERT desert1=new DESERT(emp,money,de_intro,data,de_state);
                        attenDanceService.updateDesert(desert1);
                        //生成考勤记录
                        newAttenDance.setA_state(1);
                        attenDanceService.updateAttenDanceState(newAttenDance);
                    }else if (time-endTime<=7200000&&time-endTime>3600000){//加班一个小时
                        //添加一条奖励记录
                        double money=50;
                        String de_intro="加班一个小时";
                        int de_state=1;//奖励
                        DESERT desert1=new DESERT(emp,money,de_intro,data,de_state);
                        attenDanceService.updateDesert(desert1);
                        //生成考勤记录
                        newAttenDance.setA_state(1);
                        attenDanceService.updateAttenDanceState(newAttenDance);
                    }else {//一个小时以下不算加班
                        newAttenDance.setA_state(1);
                        attenDanceService.updateAttenDanceState(newAttenDance);
                    }
                }
            }
            return "emp/empMain";
        }
    }
}
