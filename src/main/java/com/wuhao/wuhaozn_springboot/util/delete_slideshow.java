package com.wuhao.wuhaozn_springboot.util;

import org.springframework.util.ClassUtils;

import java.io.File;

public class delete_slideshow {

    public boolean delete_path(String image_path_url_old){
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static";
        String pathname=path+image_path_url_old;
        File file =new File(pathname);

        return file.delete();
    }
}
