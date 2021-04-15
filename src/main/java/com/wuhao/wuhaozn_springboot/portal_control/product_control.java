package com.wuhao.wuhaozn_springboot.portal_control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.portal_service.product_service_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class product_control {

    @Autowired
    product_service_ productService;

    @GetMapping({"/services"})
    public  String services(Model model){
        Page<product_bean> product_beanPage =new Page<>(1,30);
        IPage<product_bean> iPage=productService.select_product(product_beanPage);
        List<product_bean> list = iPage.getRecords();
        model.addAttribute("product",list);
        return "services";
    }



}
