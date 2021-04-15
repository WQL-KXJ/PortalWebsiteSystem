package com.wuhao.wuhaozn_springboot.protal_mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Slideshow_bean;
import org.apache.ibatis.annotations.*;

public interface slideshow_mapper {

    @Select("select * from slideshow")
    public IPage<Slideshow_bean> select_slideshow(Page page);

    @Update("update slideshow set image_path_url=#{image_path_url_new},image_information=#{image_information} where image_path_url=#{image_path_url_old}")
    public boolean update_slideshow(String image_path_url_new,String image_path_url_old,String image_information);

    @Insert("insert into slideshow(image_path_url,image_information) values (#{image_path_url},#{image_information})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public boolean insert_slideshow(Slideshow_bean slideshowBean);

    @Delete("delete from slideshow where image_path_url=#{image_path_url_old}")
    public boolean delete_slideshow(String image_path_url_old);
}