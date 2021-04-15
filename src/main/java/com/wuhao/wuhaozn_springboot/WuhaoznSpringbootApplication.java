package com.wuhao.wuhaozn_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.wuhao.wuhaozn_springboot.mapper","com.wuhao.wuhaozn_springboot.protal_mapper"})
public class WuhaoznSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuhaoznSpringbootApplication.class, args);
    }

}


