package com.wuhao.wuhaozn_springboot.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class kaptcha_config {

        @Bean
        public DefaultKaptcha getkaptcha(){
            Properties properties =new Properties();
            properties.put("kaptcha.image.width","180");//图片宽
            properties.put("kaptcha.image.height","80");//图片高
            properties.put("kaptcha.textproducer.char.length", "4");//验证码的长度
            properties.put("kaptcha.border","no");//设置边框
            properties.put("kaptcha.textproducer.font.size", "50");//字体大小
            properties.put("kaptcha.textproducer.font.color","green");//设置字体的颜色
            properties.put("kaptcha.textproducer.char.space","4");//设置文字的间隔
            properties.put("kaptcha.textproducer.font.names", "微软雅黑");//设置字体的样式
            properties.put("kaptcha.noise.color","blue");//干扰线的颜色
            properties.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");//背景样式
            Config config =new Config(properties);
            DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
            defaultKaptcha.setConfig(config);
            return defaultKaptcha;
        }


}
