package com.wuhao.wuhaozn_springboot.control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.server.case_ser;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/case")
public class case_show_control {

    @Autowired
    case_ser caseService;


    @GetMapping("/case_show_table")
    @ResponseBody
    public Map<String, Object> case_show_table(@RequestParam("page") int num, @RequestParam("limit") int size){
        Page<case_bean> page = new Page<case_bean>(num,size);

        IPage<case_bean> iPage= caseService.select_case(page);

        long tatol = iPage.getTotal();

        List<case_bean> list =  iPage.getRecords();


        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",tatol);
        map.put("data",list);

        return map;
    }

    @GetMapping("/case_showjubu_table")
    @ResponseBody
    public Map<String,Object>  case_showjubu_table(@RequestParam("page") int num,@RequestParam("limit") int size,@RequestParam("case_name") String name){

        Page<case_bean> case_beanPage =new Page<>(num,size);

        IPage<case_bean> iPage = caseService.select_jub_case(case_beanPage,name);

        List<case_bean> list =  iPage.getRecords();
        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",iPage.getTotal());
        map.put("data",list);
        return map;
    }




    @PostMapping("/delete_id")
    @ResponseBody
    public StateUtil case_tables(@RequestParam("id") int id){
        boolean tf=caseService.delete_id(id);
        System.out.println(tf);
        if(tf){

            return new StateUtil("成功",200);

        }

        return new StateUtil("失败",400);
    }

    @GetMapping("/case_table")
    public String case_table(){


        return "page/table_successfulcase";
    }
    @PostMapping("/updateimage")
    @ResponseBody
    public  StateUtil updateimage(String product_image,int id){

        boolean a= caseService.updateimage(product_image,id);

        if(a){
            return  new StateUtil("成功",200);
        }
        return  new StateUtil("失败",400);

    }


    @PostMapping("/show_detailpage")
    @ResponseBody
    public StateUtil show_detailpage(String name, HttpSession httpSession){
        case_bean productBean= caseService.select_detailpage(name);
        httpSession.setAttribute("detailpage_name",productBean.getCase_name());
        httpSession.setAttribute("detailpage_content",productBean.getCase_content());
        return new StateUtil("成功",200);
    }
}
