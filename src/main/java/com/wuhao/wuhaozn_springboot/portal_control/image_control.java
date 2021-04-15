package com.wuhao.wuhaozn_springboot.portal_control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Image_bean;
import com.wuhao.wuhaozn_springboot.server.image_service;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class image_control {

    @Autowired
    image_service imageService;

    @GetMapping("/image_databse")
    public  String select_image_database(Model model){
        Page<Image_bean> page = new Page<>(1,150);

        IPage<Image_bean> iPage = imageService.select_image(page);

        List<Image_bean> list=iPage.getRecords();

        model.addAttribute("images",list);
        return "page/menu";
    }

    @PostMapping("/image_update")
    @ResponseBody
    public StateUtil image_update(String image_name_new,String image_name_old){

        boolean s=imageService.update_image(image_name_new,image_name_old);
        if(s){
            return  new StateUtil("成功",200);

    }
        return  new StateUtil("失败",400);

    }

    @PostMapping("/image_delete")
    @ResponseBody
    public  StateUtil image_delete(String image_name){

        boolean s = imageService.delete_image(image_name);

        if(s){
            return  new StateUtil("成功",200);

        }
        return  new StateUtil("失败",400);
    }



}
