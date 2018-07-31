package com.zy.controller;

import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.myutil.Pages5;
import com.zy.myutil.Time;
import com.zy.service.DepartService;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Controller
public class Depart {
    @Resource
    private DepartService departService;
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/getdepartmain")
    public String getdepartmain(){
        return "admin/depart/departMain";
    }
    @RequestMapping("/addDepart")
    public String addDepart(){
        return "admin/depart/addDepart";
    }
    @RequestMapping("/getDepartName")
    @ResponseBody
    public String getDepartName(String name){
        T_DEPARTMENT t_department1=departService.getDepartName(name);
        if (t_department1==null){
            return null;
        }else {
            return "1";
        }
    }
    @RequestMapping("/addDeparts")
    public String addDeparts(T_DEPARTMENT t_department){
        String s=Time.time();
        t_department.setD_time(s);
        departService.addDeparts(t_department);
        return "admin/depart/departMain";
    }
    @RequestMapping("/getDepart")
    public String getDepart(int currentPage,HttpSession session){
        List<T_DEPARTMENT> depart = recruitmentService.getDepart();

        if (depart.size()==0){
            return "admin/AdminMain";
        }
        int toalpages=depart.size();
        int totalPages = Pages5.getTotalPages(toalpages);
        final int pages=5;
        List<T_DEPARTMENT> departlimit=departService.getDepartLimit(currentPage,pages);
        session.setAttribute("depart",departlimit);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("currentPage",currentPage);
        return "admin/depart/getDepart";
    }
    @RequestMapping("/updateDepart")
    public String updateDepart(T_DEPARTMENT t_department){
        departService.updateDepart(t_department);
        return "admin/depart/departMain";
    }
    @RequestMapping("/removeDepart")
    @ResponseBody
    public Object removeDepart(int did){
        List<T_POSITON> t_positons=departService.getPositonID(did);
        if (t_positons.size()==0){
            departService.removeDepart(did);
            return true;
        }else {
            List<EMP> emps=departService.getEmpID(t_positons);
            if (emps.size()==0){
                departService.removePositon(t_positons);
                departService.removeDepart(did);
                return true;
            }
        }
        return null;
    }

}
