package com.wuhao.wuhaozn_springboot.skip;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Slideshow_bean;
import com.wuhao.wuhaozn_springboot.bean.company_information;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.portal_service.slideshow_service;
import com.wuhao.wuhaozn_springboot.server.company_service;
import com.wuhao.wuhaozn_springboot.server.patents_service;
import com.wuhao.wuhaozn_springboot.server.product_ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class index {


    @Autowired
    company_service companyService;

    @Autowired
    slideshow_service slideshowService;

    @Autowired
    product_ser productService;

    @Autowired
    patents_service patentsService;

@GetMapping({"/home","/"})
public String log(HttpSession session){

    company_information s= companyService.select_company();
    session.setAttribute("company_phone",s.getCompany_phone());
    session.setAttribute("company_place",s.getCompany_place());
    session.setAttribute("company_intro",s.getCompany_intro());
    session.setAttribute("company_content",s.getCompany_content());
    session.setAttribute("company_image",s.getCompany_image());
    Page<Slideshow_bean> page =new Page<Slideshow_bean>(1,20);
    List<Slideshow_bean> list = slideshowService.select_slideshow(page).getRecords();
    session.setAttribute("company_list",list);

    Random random = new Random();
    List<product_bean> list1=productService.select_product();
    if(list1.size()!=0) {
        List<product_bean> list2 = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String index = "cp" + i;
            list2.add(list1.get(random.nextInt(list1.size())));
        }
        session.setAttribute("cp", list2);
    }else {
        product_bean wran =new product_bean();
        wran.setProduct_image("/layuimini/images/400.jpg");
        list1.add(wran);
        session.setAttribute("cp",list1);
    }

    List<patents_bean> list3=patentsService.select_patents();
    if(list3.size()!=0) {
        List<patents_bean> list4 = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            list4.add(list3.get(random.nextInt(list3.size())));
        }
        session.setAttribute("zl", list4);

    }else {
       patents_bean warn= new patents_bean();
        warn.setPatents_name("没有添加任何专利");
        warn.setPatents_brief("没有添加任何专利");
        warn.setPatents_image("/layuimini/images/400.jpg");
        list3.add(warn);
        session.setAttribute("zl", list3);
    }

    return "index";
}

@GetMapping({"/about"})
public  String about(){

    return "about";
}

    @GetMapping({"/detailpages_services"})
    public  String detailpages_services(){

        return "detailpages_services";
    }

}
