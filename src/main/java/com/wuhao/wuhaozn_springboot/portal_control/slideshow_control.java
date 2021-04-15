package com.wuhao.wuhaozn_springboot.portal_control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Image_bean;
import com.wuhao.wuhaozn_springboot.bean.Slideshow_bean;
import com.wuhao.wuhaozn_springboot.portal_service.slideshow_service;
import com.wuhao.wuhaozn_springboot.server.image_service;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class slideshow_control {

    @Autowired
    slideshow_service slideshowService;

    @Autowired
    image_service imageService;

    @GetMapping("/slideshow")
    public String get_slideshow(Model model){
        Page<Slideshow_bean> page =new Page<Slideshow_bean>(1,30);
        IPage<Slideshow_bean> iPage=slideshowService.select_slideshow(page);
        List<Slideshow_bean> list=iPage.getRecords();
        model.addAttribute("slideshow",list);
        return "page/sldieshow";
    }

    @PostMapping("/add_slideshow")
    @ResponseBody
    public StateUtil add_slideshow(Slideshow_bean slideshowBean){
        boolean s=slideshowService.insert_slideshow(slideshowBean);
        int index=slideshowBean.getImage_path_url().lastIndexOf("/");
        Image_bean image_bean =new Image_bean();
        image_bean.setImage_name(slideshowBean.getImage_path_url().substring(index+1));
        image_bean.setImage_type("3");
        image_bean.setImage_to("0");
        image_bean.setImage_to_id(slideshowBean.getId());
        imageService.insert_image(image_bean);
        if (s){
            return new StateUtil("成功",200);
        }
        return new StateUtil("失败",400);
    }


    @PostMapping("/delete_slideshow")
    @ResponseBody
    public StateUtil delete_slideshow(String image_path_url_old){
        boolean s=slideshowService.delete_slideshow(image_path_url_old);
        if(s){
            return new StateUtil("成功",200);
        }
    return new StateUtil("失败",400);
    }

    @PostMapping("/update_slideshow")
    @ResponseBody
    public  StateUtil update_slideshow(String image_path_url_new,String image_path_url_old,String image_information){

        boolean s=slideshowService.update_slideshow(image_path_url_new,image_path_url_old,image_information);

        if(s){
            return new StateUtil("成功",200);
        }
        return new StateUtil("失败",400);
    }



}
