package com.wuhao.wuhaozn_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import  com.wuhao.wuhaozn_springboot.bean.Image_bean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface image_mapper extends BaseMapper<Image_bean> {

    @Select("select * from image_database")
    public IPage<Image_bean> select_image(Page page);

    @Insert("insert into image_database (image_name,image_type,image_to,image_to_id) values (#{image_name},#{image_type},#{image_to},#{image_to_id})")
    public  boolean insert_image(Image_bean imageBean);

    @Update("update image_database set image_name=#{image_name_new} where image_name=#{image_name_old}")
    public  boolean update_images(String image_name_new,String image_name_old);

    @Delete("delete from image_database where image_name=#{image_name}")
    public boolean delete_image(String image_name);


}
