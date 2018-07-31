package com.zy.controller;

import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.myutil.Pages5;
import com.zy.myutil.Time;
import com.zy.service.PositonService;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@Controller
public class PositonController {
    @Resource
    private PositonService positonService;
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/addPositon")
    public String addPositon(HttpSession session){
        List<T_DEPARTMENT> depart = recruitmentService.getDepart();
        session.setAttribute("depart",depart);
        return "admin/positon/addPositon";
    }
    @RequestMapping("/getPositonName")
    @ResponseBody
    public String getPositonName(String name,int did){
        T_POSITON t_positon=positonService.getPositonName(name,did);
        if (t_positon==null){
            return null;
        }else {
            return "1";
        }
    }
    @RequestMapping("/addPositons")
    public String addPositons(T_POSITON t_positon){
        String s=Time.time();
        t_positon.setP_time(s);
        positonService.addPositons(t_positon);
        return "admin/depart/departMain";
    }
    @RequestMapping("/getPositons")
    public String getPositons(int currentPage,HttpSession session){
        List<T_POSITON> t_positons=positonService.getPositons();
        if (t_positons.size()==0){
            return "admin/depart/departMain";
        }
        int totalpages=t_positons.size();
        int totalPages = Pages5.getTotalPages(totalpages);
        final int pages=5;
        List<T_POSITON> t_positons1=positonService.getPositonsLimit(currentPage,pages);
        session.setAttribute("positon",t_positons1);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("currentPage",currentPage);
        return "admin/positon/getPositon";
    }
    @RequestMapping("/getPositonNames")
    @ResponseBody
    public Object getPositonNames(int did,int pid,String name){
        T_POSITON t_positon=positonService.getPositonNames(did,pid,name);
        if (t_positon==null){
            return null;
        }else {
            return "1";
        }
    }
    @RequestMapping("/updatePositon")
    public String updatePositon(T_POSITON t_positon){
       positonService.updatePositon(t_positon);
       return "admin/depart/departMain";
    }
    @RequestMapping("/removePositon")
    @ResponseBody
    public Object removePositon(int pid){
        List<EMP> emps = positonService.getEmps(pid);
        if (emps.size()==0){
            positonService.deletePositon(pid);
            return true;
        }
        return false;
    }
}
