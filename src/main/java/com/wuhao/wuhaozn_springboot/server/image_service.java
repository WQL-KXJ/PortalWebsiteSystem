package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.Image_bean;
import com.wuhao.wuhaozn_springboot.mapper.image_mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.File;

@Service
public class image_service implements image_ser {

    @Autowired
    image_mapper imageMapper;


    @Override
    public IPage<Image_bean> select_image(Page page) {

        return  imageMapper.select_image(page);
    }

    @Override
    public boolean insert_image(Image_bean imageBean) {


        return imageMapper.insert_image(imageBean);
    }

    @Override
    public boolean update_image(String image_name_new, String image_name_old) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/layuimini/image_out/";
        String pathname=path+image_name_old;
        File file =new File(pathname);

        if(file.delete()){
        }else{
            path=ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/layuimini/image_article/";
            pathname=path+image_name_old;
            File file1 =new File(pathname);
            if(file1.delete()){
            }else {}
        }

        return imageMapper.update_images(image_name_new,image_name_old);
    }

    @Override
    public boolean delete_image(String image_name) {

       String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/layuimini/image_out/";
       String pathname=path+image_name;
       File file =new File(pathname);

       if(file.delete()){
       }else{
           path=ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/layuimini/image_article/";
           pathname=path+image_name;
           File file1 =new File(pathname);
           if(file1.delete()){
           }else {}
       }

        return imageMapper.delete_image(image_name);
    }

    @Override
    public boolean delete_image_slideshow(String image_name) {
        return imageMapper.delete_image(image_name);
    }
}
