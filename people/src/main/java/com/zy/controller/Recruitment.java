package com.zy.controller;

import com.zy.model.T_DEPARTMENT;
import com.zy.model.T_POSITON;
import com.zy.model.T_RECRUITMENT;
import com.zy.myutil.Pages5;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
@Controller
public class Recruitment {
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/mainControlloer")
    public String getRecruitment(int currentPage, HttpSession session){
        int state=1;
        List<T_RECRUITMENT> recruitment = recruitmentService.getRecruitment(state);
        if (recruitment.size()==0){
            return "../../main";
        }
       int totalpages=recruitment.size();
        int totalPages = Pages5.getTotalPages(totalpages);
        final int pages=5;
        List<T_RECRUITMENT> recruitmentLimit = recruitmentService.getRecruitmentLimit(state,currentPage, pages);
        System.out.println(recruitmentLimit);
        session.setAttribute("recruitment",recruitmentLimit);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        return "../../main";
    }
    @RequestMapping("/updateRecruit")
    public String updateRecruit(T_RECRUITMENT t_recruitment){
        recruitmentService.updateRecruit(t_recruitment);
        return "admin/AdminMain";
    }
    @RequestMapping("/addRecruit")
    public String addRecuit(HttpSession session){
        List<T_DEPARTMENT> list=recruitmentService.getDepart();
        session.setAttribute("depart",list);
        return "admin/addRecruit";
    }
    @RequestMapping("/getPositon")
    @ResponseBody
    public Object getPositon(int did){
        List<T_POSITON> positons=recruitmentService.getPositon(did);
        return positons;
}
    @RequestMapping("/adminAddRecruit")
    public String adminAddRecruit(T_RECRUITMENT t_recruitment, HttpServletRequest request){
        int re_pid= Integer.parseInt(request.getParameter("re_pid"));
        T_POSITON t_positon=new T_POSITON();
        t_positon.setP_id(re_pid);
        t_recruitment.setT_positon(t_positon);
        recruitmentService.addRecruit(t_recruitment);
        return "admin/AdminMain";
    }
}
