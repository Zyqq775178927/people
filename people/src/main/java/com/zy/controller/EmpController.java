package com.zy.controller;

import com.zy.model.EMP;
import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.service.EmpService;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("/addEmp")
    public String addEmp(HttpSession session){
        List<T_DEPARTMENT> depart = recruitmentService.getDepart();
        System.out.println(depart);
        session.setAttribute("depart",depart);
        return "admin/emp";
    }
    @RequestMapping("/addEmps")
    public String addEmps(EMP emp, HttpServletRequest request){
        int pid= Integer.parseInt(request.getParameter("pid"));
        T_POSITON t_positon=new T_POSITON();
        t_positon.setP_id(pid);
        emp.setT_positon(t_positon);
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
}
