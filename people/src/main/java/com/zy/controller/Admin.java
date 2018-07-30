package com.zy.controller;

import com.sun.deploy.net.HttpResponse;
import com.zy.model.*;
import com.zy.myutil.Pages5;
import com.zy.myutil.Time;
import com.zy.service.AdminService;
import com.zy.service.RecruitmentService;
import com.zy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/7/27.
 */
@Controller
public class Admin {
    @Resource
    private AdminService adminService;
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private UserService userService;
    @RequestMapping("/adminLogin")
    public String getAdmin(T_ADMIN t_admin, HttpServletRequest request){
        T_ADMIN admin = adminService.getAdmin(t_admin);
        if (admin==null){
            request.setAttribute("error","用户名密码错误");
            return "../../AdminLogin";
        }
        return "admin/AdminMain";
    }
    @RequestMapping("/getRecruit")
    public String getRecruit(int currentPage, HttpSession session){

        List<T_RECRUITMENT> recruitment = recruitmentService.getRecruitment();
        if (recruitment.size()==0){
            return "../../main";
        }
        int totalpages=recruitment.size();
        int totalPages = Pages5.getTotalPages(totalpages);
        final int pages=5;
        List<T_RECRUITMENT> recruitmentLimit = recruitmentService.getRecruitmentLimit(currentPage, pages);
        System.out.println(recruitmentLimit);
        session.setAttribute("recruitment",recruitmentLimit);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        return "admin/adminRecruit";
    }
    @RequestMapping("/removeRecruit")
    public String removeRecruit(int id, HttpServletResponse response,HttpSession session) throws IOException {
        adminService.removeRecruit(id);
        System.out.println(id);
        PrintWriter writer = response.getWriter();
        writer.flush();
        writer.close();
        int currentPage=1;
        return getRecruit(currentPage,session);
    }
    @RequestMapping("/getR_R")
    public String getR_R(HttpSession session){
        List<R_R> r_rs=adminService.getR_R();
        session.setAttribute("r_r",r_rs);
        List<INVITED> invited = adminService.getInvited();
        session.setAttribute("invited",invited);
        return "admin/R_R";
    }
    @RequestMapping("/adminGetResume")
    public String adminGetResume(int rb_id,int r_id,int re_id,HttpSession session,HttpServletRequest request){
        int state=1;
        adminService.updateR_R(state,r_id);
        T_RESUME t_resume=adminService.adminGetResume(rb_id);
        if (t_resume!=null){
            request.setAttribute("re_id",re_id);
            session.setAttribute("resume1",t_resume);
            return "admin/resume";
        }
        return "admin/AdminMain";
    }
    @RequestMapping("/getR_RJSP")
    public String getR_RJSP(){
        return "admin/R_R";
    }
    @RequestMapping("/addInvited")
    public String addInted(HttpServletRequest request){
       int re_id= Integer.parseInt(request.getParameter("re_id"));
       int u_id= Integer.parseInt(request.getParameter("t_user"));
       T_RECRUITMENT t_recruitment=new T_RECRUITMENT();
       t_recruitment.setRe_id(re_id);
       T_USER t_user=new T_USER();
       t_user.setU_id(u_id);
       INVITED invited=new INVITED();
        String time= Time.timeDay1();
        invited.setI_time(time);
        invited.setT_recruitment(t_recruitment);
        invited.setT_user(t_user);
        System.out.println(invited);
        if (adminService.addInvited(invited)){
            request.setAttribute("success","邀请成功");
            return "success";
        }
        return "admin/resume";
    }
    @RequestMapping("/adminUpdateInvited")
    public String adminUpdateInvited(int id,int state){
        userService.updateInvited(id,state);
        return "admin/AdminMain";
    }
}
