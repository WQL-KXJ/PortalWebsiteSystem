package com.wuhao.wuhaozn_springboot.portal_control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.portal_service.case_service_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class case_control {
    @Autowired
    case_service_ caseService;

    @GetMapping({"/successful"})
    public  String services(Model model){
        Page<case_bean> case_beanPage =new Page<case_bean>(1,30);
        IPage<case_bean> iPage=caseService.select_case(case_beanPage);
        List<case_bean> list = iPage.getRecords();
        model.addAttribute("case",list);
        return "successful";
    }
}
