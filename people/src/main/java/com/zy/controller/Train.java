package com.zy.controller;

import com.zy.model.EMP;
import com.zy.model.TRAIN;
import com.zy.model.T_DEPARTMENT;
import com.zy.myutil.Pages5;
import com.zy.myutil.Time;
import com.zy.service.RecruitmentService;
import com.zy.service.TrainService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@Controller
public class Train {
    @Resource
    private TrainService trainService;
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/trainmain")
    public String trainmain(){
        return "admin/train/trainMain";
    }
    @RequestMapping("/addTrain")
    public String addTrain(HttpSession session){
        List<T_DEPARTMENT> depart = recruitmentService.getDepart();
        session.setAttribute("depart",depart);
        return "admin/train/addTrain";
    }
    @RequestMapping("/addTarin")
    public String addTarin(TRAIN train, Integer depart, Integer position){
        trainService.addTrain(train);
        System.out.println(train);
        if (position==0){
            if (depart==0){
                //培训实习期
                List<EMP> empID = trainService.getEmpID(depart);
                for (int i=0;i<empID.size();i++){
                    trainService.addEmpAndTrain(train.getT_id(),empID.get(i).getE_id());
                }
            }else {
                //培训部门的
                List<EMP> emps=trainService.getEmps(depart);
                for (int i=0;i<emps.size();i++){
                    trainService.addEmpAndTrain(train.getT_id(),emps.get(i).getE_id());
                }
            }
        }else {//培训职位的
            List<EMP> emps=trainService.getEmpPositon(depart,position);
            for (int i=0;i<emps.size();i++){
                trainService.addEmpAndTrain(train.getT_id(),emps.get(i).getE_id());
            }
        }
        return "admin/train/trainMain";
    }
    @RequestMapping("/getTrain")
    public String getTrain(int currentPage,HttpSession session){
        List<TRAIN> train = trainService.getTrain();
        int totalPages=train.size();
        int totalPages1 = Pages5.getTotalPages(totalPages);
        final int pages=5;
        List<TRAIN> trainLimit = trainService.getTrainLimit(currentPage, pages);
        session.setAttribute("train",trainLimit);
        session.setAttribute("totalPages1",totalPages1);
        session.setAttribute("currentPage",currentPage);
        return "admin/train/getTrain";
    }
    @RequestMapping("/updateTrain")
    public String updateTrain(TRAIN train,HttpSession session){
        trainService.updateTrain(train);
        int currentPage=1;
        return getTrain(currentPage,session);
    }
    @RequestMapping("/updateState")
    @ResponseBody
    public Object updateState(int t_id,int t_state) throws ParseException {
        if (t_state==0){
            t_state=1;
            String time=Time.time();
            TRAIN train=new TRAIN();
            train.setT_id(t_id);
            train.setT_time(time);
            train.setT_state(t_state);
            trainService.updateTrainState(train);
            return true;
        }else {
            TRAIN trainID = trainService.getTrainID(t_id);
            long time=System.currentTimeMillis();
            String dateTime =trainID.getT_time();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(dateTime);
            long t_time = date.getTime();
            if (time-t_time>600000){
                return false;
            }else {
                trainID.setT_state(0);
                System.out.println(trainID);
                trainService.updateTrainState(trainID);
                return true;
            }
        }
    }
}
