package com.wuhao.wuhaozn_springboot.portal_control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.portal_service.patent_service_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class patent_control {
    @Autowired
    patent_service_ patentService;

    @GetMapping({"/blog"})
    public  String services(Model model){
        Page<patents_bean> patent_beanPage =new Page<patents_bean>(1,30);
        IPage<patents_bean> iPage=patentService.select_patent(patent_beanPage);
        List<patents_bean> list = iPage.getRecords();
        model.addAttribute("patent",list);
        return "blog";
    }
}
