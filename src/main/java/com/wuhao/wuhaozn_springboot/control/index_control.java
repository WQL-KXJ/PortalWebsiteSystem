package com.wuhao.wuhaozn_springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class index_control {

@GetMapping("/index")
    public  String index_wql(){

    return "page/index";
}





}
