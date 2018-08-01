package com.zy.controller;

import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.myutil.Pages5;
import com.zy.myutil.Time;
import com.zy.service.DepartService;
import com.zy.service.EmpService;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Controller
public class EmpController {
    @Resource
    private EmpService empService;
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private DepartService departService;
    @RequestMapping("/addEmp")
    public String addEmp(HttpSession session){
        List<T_DEPARTMENT> depart = recruitmentService.getDepart();
        session.setAttribute("depart",depart);
        return "admin/emp";
    }
    @RequestMapping("/addEmps")
    public String addEmps(EMP emp, HttpServletRequest request){
        int pid= Integer.parseInt(request.getParameter("pid"));
        int did= Integer.parseInt(request.getParameter("did"));
        T_POSITON t_positon=new T_POSITON();
        T_DEPARTMENT t_department=new T_DEPARTMENT();
        t_positon.setP_id(pid);
        t_department.setD_id(did);
        emp.setT_positon(t_positon);
        emp.setT_department(t_department);
        String time=Time.time2();
        emp.setE_time(time);
        empService.addEmp(emp);
        return "admin/AdminMain";
    }
    @RequestMapping(value = "/getEmpName",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getEmpName(String name, HttpServletRequest request, HttpServletResponse response){
            EMP empName = empService.getEmpName(name);
            if (empName==null){
                return null;
            }else {
                return "1";
            }
    }
    @RequestMapping("/empmains")
    public String getEmpMain(){
        return "admin/emp/empMain";
    }
    @RequestMapping("/getEmp")
    public String getEmp(HttpSession session,int currentPage,HttpServletRequest request){
        List<T_DEPARTMENT> depart = recruitmentService.getDepart();
        session.setAttribute("depart",depart);
        session.setAttribute("currentPage",currentPage);
        return "admin/emp/getEmp";
    }
    @RequestMapping("/getEmpAndDep")
    public String getEmpAndDep(Integer d_id,Integer e_state, int currentPage,Integer position,HttpServletRequest request,HttpSession session){
        List<EMP> empID = empService.getEmp(d_id,e_state);
        int totalPages=empID.size();
        int totalPages1 = Pages5.getTotalPages(totalPages);
        final int pages=5;
        if (position==0){
            List<EMP> empLimit=empService.getEmpLimits(d_id,currentPage,pages,e_state);
            session.setAttribute("empLimit",empLimit);
        }else {
            List<EMP> empList=empService.getEmpLimit(d_id,currentPage,pages,e_state,position);
            session.setAttribute("empLimit",empList);
        }
        session.setAttribute("d_id",d_id);
        session.setAttribute("e_state",e_state);
        session.setAttribute("totalPages1",totalPages1);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("position",position);
        return "admin/emp/findEmpAndDep";
    }
    @RequestMapping("/getEmpjsp")
    public String getEmpjsp(){
        return "admin/emp/getEmp";
    }
}
