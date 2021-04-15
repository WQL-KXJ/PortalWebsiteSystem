package com.wuhao.wuhaozn_springboot.control;

import com.wuhao.wuhaozn_springboot.bean.*;
import com.wuhao.wuhaozn_springboot.server.*;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class Product_all_control {
    @Autowired
    product_service productService;

    @Autowired
    patents_service patentsService;

    @Autowired
    case_service caseService;

    @Autowired
    solution_service solutionServices;

    @Autowired
    image_service imageService;
    @PostMapping("/product")
    @ResponseBody
    public StateUtil insert_product(product_bean productBean){
        if(!ObjectUtils.isEmpty(productBean)) {
            int code = productService.insert_product(productBean);
            int index=productBean.getProduct_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(productBean.getProduct_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("1");
            image_bean.setImage_to_id(productBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

               return new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }


        return new StateUtil("添加失败！",400);
    }

    @PostMapping("/patents")
    @ResponseBody
    public StateUtil insert_patents(patents_bean patentsBean){
        if(!ObjectUtils.isEmpty(patentsBean)) {
            int code = patentsService.insert_patents(patentsBean);
            int index=patentsBean.getPatents_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(patentsBean.getPatents_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("2");
            image_bean.setImage_to_id(patentsBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

                return   new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }

    @PostMapping("/case")
    @ResponseBody
    public StateUtil insert_case(case_bean caseBean){
        if(!ObjectUtils.isEmpty(caseBean)) {
            int code = caseService.insert_case(caseBean);
            int index=caseBean.getCase_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(caseBean.getCase_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("3");
            image_bean.setImage_to_id(caseBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

                return  new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }


    @PostMapping("/solution")
    @ResponseBody
    public StateUtil insert_solution(solution_bean solutionBean){
        if(!ObjectUtils.isEmpty(solutionBean)) {
            int code =solutionServices.insert_solution(solutionBean);
            int index=solutionBean.getSolution_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(solutionBean.getSolution_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("4");
            image_bean.setImage_to_id(solutionBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

                return  new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }
}
