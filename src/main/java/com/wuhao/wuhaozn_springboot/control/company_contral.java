package com.wuhao.wuhaozn_springboot.control;


import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.company_information;
import com.wuhao.wuhaozn_springboot.server.company_service;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class company_contral {

    @Autowired
    company_service companyService;

    @PostMapping("/update_company")
    @ResponseBody
    public StateUtil update_company(company_information companyInformation){
       boolean s= companyService.update_company(companyInformation);
        if(s) {
            return new StateUtil("成功", 200);
        }
        return  new StateUtil("失败",400);
    }

    @GetMapping({"/company"})
    public  String company(HttpSession session){

        company_information s= companyService.select_company();
        session.setAttribute("company_phone",s.getCompany_phone());
        session.setAttribute("company_place",s.getCompany_place());
        session.setAttribute("company_intro",s.getCompany_intro());

        return "page/company";
    }

    @PostMapping("/select_company")
    @ResponseBody
    public company_information select_company(){

        return companyService.select_company();
    }
    @PostMapping("/show_detailpage_gy")
    @ResponseBody
    public StateUtil show_detailpage(int name, HttpSession httpSession){
        company_information productBean= companyService.select_company_gy(name);
        httpSession.setAttribute("detailpage_name","关于我们");
        httpSession.setAttribute("detailpage_content",productBean.getCompany_content());
        return new StateUtil("成功",200);
    }
}
