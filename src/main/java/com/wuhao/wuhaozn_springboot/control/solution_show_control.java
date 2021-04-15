package com.wuhao.wuhaozn_springboot.control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.server.solution_ser;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/solution")
public class solution_show_control {
    @Autowired
    solution_ser solutionService;

    @GetMapping("/solution_show_table")
    @ResponseBody
    public Map<String, Object> solution_show_table(@RequestParam("page") int num, @RequestParam("limit") int size){
        Page<solution_bean> page = new Page<solution_bean>(num,size);

        IPage<solution_bean> iPage= solutionService.select_solution(page);

        long tatol = iPage.getTotal();

        List<solution_bean> list =  iPage.getRecords();


        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",tatol);
        map.put("data",list);

        return map;
    }

    @GetMapping("/solution_showjubu_table")
    @ResponseBody
    public Map<String,Object>  solution_showjubu_table(@RequestParam("page") int num,@RequestParam("limit") int size,@RequestParam("solution_name") String name){

        Page<solution_bean> solution_beanPage =new Page<>(num,size);

        IPage<solution_bean> iPage = solutionService.select_jub_solution(solution_beanPage,name);

        List<solution_bean> list =  iPage.getRecords();
        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",iPage.getTotal());
        map.put("data",list);
        return map;
    }




    @PostMapping("/delete_id")
    @ResponseBody
    public StateUtil solution_tables(@RequestParam("id") int id){
        boolean tf=solutionService.delete_id(id);
        System.out.println(tf);
        if(tf){

            return new StateUtil("成功",200);

        }

        return new StateUtil("失败",400);
    }

    @GetMapping("/solution_table")
    public String solution_table(){


        return "page/table_solution";
    }


    @PostMapping("/updateimage")
    @ResponseBody
    public  StateUtil updateimage(String product_image,int id){

        boolean a= solutionService.updateimage(product_image,id);

        if(a){
            return  new StateUtil("成功",200);
        }
        return  new StateUtil("失败",400);

    }


    @PostMapping("/show_detailpage")
    @ResponseBody
    public StateUtil show_detailpage(String name, HttpSession httpSession){
        solution_bean productBean= solutionService.select_detailpage(name);
        httpSession.setAttribute("detailpage_name",productBean.getSolution_name());
        httpSession.setAttribute("detailpage_content",productBean.getSolution_content());
        return new StateUtil("成功",200);
    }
}
