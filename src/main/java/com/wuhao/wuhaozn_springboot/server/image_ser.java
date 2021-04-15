package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import  com.wuhao.wuhaozn_springboot.bean.Image_bean;
public interface image_ser {

    public IPage<Image_bean> select_image(Page page);

    public  boolean insert_image (Image_bean image);

    public  boolean update_image(String image_name_new,String image_name_old);

    public boolean delete_image(String image_name);
    public boolean delete_image_slideshow(String image_name);
}
