package com.wuhao.wuhaozn_springboot.control;

import com.wuhao.wuhaozn_springboot.bean.Image_bean;
import com.wuhao.wuhaozn_springboot.server.image_service;
import com.wuhao.wuhaozn_springboot.util.Uploadimage_load;
import com.wuhao.wuhaozn_springboot.util.article_images;
import com.wuhao.wuhaozn_springboot.util.data_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class article_image {

    @Autowired
    image_service imageService;

    @PostMapping("/article_image")
    @ResponseBody
    public article_images upload_image(@RequestParam(value = "file") MultipartFile file, Model model) throws IOException {
        if(!file.isEmpty()) {

            String file_name = file.getOriginalFilename();
            String fuffixname = file_name.substring(file_name.lastIndexOf("."));


            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/layuimini/image_article/";

            String filePath =  UUID.randomUUID() + fuffixname;

            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(filePath);
            image_bean.setImage_type("2");
            image_bean.setImage_to("0");
            image_bean.setImage_to_id(0);
            imageService.insert_image(image_bean);

            File file1 = new File(path+filePath);

            file.transferTo(file1);

            System.out.println("上传完成！！");
            return new article_images(0,"上传成功",new data_util("/layuimini/image_article/"+filePath,"无"));

        }else {

            System.out.println("文件为空！！");

        }
        return new article_images(400,"上传失败",new data_util("/layuimini/image_article/","无"));
    }

}
