package com.wuhao.wuhaozn_springboot.control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.server.product_ser;
import com.wuhao.wuhaozn_springboot.server.product_service;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class Table_show_control {
    @Autowired
    product_ser productService;

    @GetMapping("/product_show_table")
    @ResponseBody
    public  Map<String, Object> product_show_table(@RequestParam("page") int num,@RequestParam("limit") int size){
        Page<product_bean> page = new Page<product_bean>(num,size);

        IPage<product_bean> iPage= productService.select_product(page);

        long tatol = iPage.getTotal();

        List<product_bean> list =  iPage.getRecords();


        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",tatol);
        map.put("data",list);

        return map;
    }

    @GetMapping("/product_showjubu_table")
    @ResponseBody
    public Map<String,Object>  product_showjubu_table(@RequestParam("page") int num,@RequestParam("limit") int size,@RequestParam("product_name") String name){

        Page<product_bean> product_beanPage =new Page<>(num,size);

        IPage<product_bean> iPage = productService.select_jub_product(product_beanPage,name);

        List<product_bean> list =  iPage.getRecords();
        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",iPage.getTotal());
        map.put("data",list);
        return map;
    }




    @PostMapping("/delete_id")
    @ResponseBody
    public StateUtil product_tables(@RequestParam("id") int id){
        boolean tf=productService.delete_id(id);
        System.out.println(tf);
        if(tf){

            return new StateUtil("成功",200);

        }

        return new StateUtil("失败",400);
    }

    @PostMapping("/updateimage")
    @ResponseBody
    public  StateUtil updateimage(String product_image,int id){

       boolean a= productService.updateimage(product_image,id);
        System.out.println(a);
        if(a){
            return  new StateUtil("成功",200);
        }
        return  new StateUtil("失败",400);

    }


   @PostMapping("/show_detailpage")
   @ResponseBody
   public StateUtil show_detailpage(String name, HttpSession httpSession){
       product_bean productBean= productService.select_detailpage(name);
       httpSession.setAttribute("detailpage_name",productBean.getProduct_name());
       httpSession.setAttribute("detailpage_content",productBean.getProduct_content());
        return new StateUtil("成功",200);
   }





    @GetMapping("/product_table")
    public String product_table(){


        return "page/table";
}}
