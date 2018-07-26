package com.zy.controller;

import com.zy.model.T_RECRUITMENT;
import com.zy.myutil.Pages5;
import com.zy.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26.
 */
@Controller
public class Recruitment {
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/main")
    public String getRecruitment(int currentPage, HttpSession session){
        int state=1;
        List<T_RECRUITMENT> recruitment = recruitmentService.getRecruitment(state);
        if (recruitment.size()==0){
            return "../../main";
        }
       int totalpages=recruitment.size();
        int totalPages = Pages5.getTotalPages(totalpages);
        final int pages=5;
        List<T_RECRUITMENT> recruitmentLimit = recruitmentService.getRecruitmentLimit(state, currentPage, pages);
        session.setAttribute("recruitment",recruitmentLimit);
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("totalPages",totalPages);
        return "../../main";
    }
}
