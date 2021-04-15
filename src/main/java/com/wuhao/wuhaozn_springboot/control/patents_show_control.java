package com.wuhao.wuhaozn_springboot.control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.server.patents_ser;
import com.wuhao.wuhaozn_springboot.server.patents_ser;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patents")
public class patents_show_control {

    @Autowired
    patents_ser patentsService;
    @GetMapping("/patents_show_table")
    @ResponseBody
    public Map<String, Object> patents_show_table(@RequestParam("page") int num, @RequestParam("limit") int size){
        Page<patents_bean> page = new Page<patents_bean>(num,size);

        IPage<patents_bean> iPage= patentsService.select_patents(page);

        long tatol = iPage.getTotal();

        List<patents_bean> list =  iPage.getRecords();


        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",tatol);
        map.put("data",list);

        return map;
    }

    @GetMapping("/patents_showjubu_table")
    @ResponseBody
    public Map<String,Object>  patents_showjubu_table(@RequestParam("page") int num,@RequestParam("limit") int size,@RequestParam("patents_name") String name){

        Page<patents_bean> patents_beanPage =new Page<>(num,size);

        IPage<patents_bean> iPage = patentsService.select_jub_patents(patents_beanPage,name);

        List<patents_bean> list =  iPage.getRecords();
        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",iPage.getTotal());
        map.put("data",list);
        return map;
    }




    @PostMapping("/delete_id")
    @ResponseBody
    public StateUtil patents_tables(@RequestParam("id") int id){
        boolean tf=patentsService.delete_id(id);

        if(tf){

            return new StateUtil("成功",200);

        }

        return new StateUtil("失败",400);
    }

    @GetMapping("/patents_table")
    public String patents_table(){


        return "page/table_patent";
    }
    @PostMapping("/updateimage")
    @ResponseBody
    public  StateUtil updateimage(String product_image,int id){

        boolean a= patentsService.updateimage(product_image,id);

        if(a){
            return  new StateUtil("成功",200);
        }
        return  new StateUtil("失败",400);

    }


    @PostMapping("/show_detailpage")
    @ResponseBody
    public StateUtil show_detailpage(String name, HttpSession httpSession){
        patents_bean productBean= patentsService.select_detailpage(name);
        httpSession.setAttribute("detailpage_name",productBean.getPatents_name());
        httpSession.setAttribute("detailpage_content",productBean.getPatents_content());
        return new StateUtil("成功",200);
    }


}
