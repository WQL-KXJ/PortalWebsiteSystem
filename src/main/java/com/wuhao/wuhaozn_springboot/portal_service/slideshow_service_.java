package com.wuhao.wuhaozn_springboot.portal_service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Image_bean;
import com.wuhao.wuhaozn_springboot.bean.Slideshow_bean;
import com.wuhao.wuhaozn_springboot.mapper.image_mapper;
import com.wuhao.wuhaozn_springboot.protal_mapper.slideshow_mapper;
import com.wuhao.wuhaozn_springboot.server.image_service;
import com.wuhao.wuhaozn_springboot.util.delete_slideshow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.File;

@Service
public class slideshow_service_ implements slideshow_service {

    delete_slideshow deleteSlideshow;
    @Autowired
    slideshow_mapper slideshowMapper;

    @Autowired
    image_service imageService;

    @Override
    public IPage<Slideshow_bean> select_slideshow(Page page) {
        return slideshowMapper.select_slideshow(page);
    }


    @Override
    public boolean update_slideshow(String image_path_url_new,String image_path_url_old,String image_information) {

        deleteSlideshow= new delete_slideshow();
        deleteSlideshow.delete_path(image_path_url_old);

        int last_index_old=image_path_url_old.lastIndexOf("/")+1;
        String sub_old=image_path_url_old.substring(last_index_old);

        int last_index_new=image_path_url_new.lastIndexOf("/")+1;
        String sub_new=image_path_url_new.substring(last_index_new);

        imageService.update_image(sub_new,sub_old);

        return slideshowMapper.update_slideshow(image_path_url_new,image_path_url_old,image_information);
    }





    @Override
    public boolean insert_slideshow(Slideshow_bean slideshowBean) {



        return slideshowMapper.insert_slideshow(slideshowBean);
    }

    @Override
    public boolean delete_slideshow(String image_path_url_old) {

        int last_index_olds = image_path_url_old.lastIndexOf("/")+1;
        String sub_old=image_path_url_old.substring(last_index_olds);

        deleteSlideshow= new delete_slideshow();
        deleteSlideshow.delete_path(image_path_url_old);

        imageService.delete_image_slideshow(sub_old);
        return slideshowMapper.delete_slideshow(image_path_url_old);
    }




}
