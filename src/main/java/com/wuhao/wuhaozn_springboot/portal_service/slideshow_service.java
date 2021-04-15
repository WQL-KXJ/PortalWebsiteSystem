package com.wuhao.wuhaozn_springboot.portal_service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Slideshow_bean;

public interface slideshow_service {

    public IPage<Slideshow_bean> select_slideshow(Page page);
    public boolean update_slideshow(String image_path_url_new,String image_path_url_old,String image_information);
    public boolean insert_slideshow(Slideshow_bean slideshowBean);
    public boolean delete_slideshow(String image_path_url_old);
}
