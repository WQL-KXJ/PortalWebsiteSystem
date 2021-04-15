package com.wuhao.wuhaozn_springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class essential_contral {

    @GetMapping("/essential")
    public String essential(){


        return "page/essential";
    }



}
