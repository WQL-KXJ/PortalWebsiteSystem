package com.wuhao.wuhaozn_springboot.portal_control;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.protal_mapper.solutions_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class solution_control {

    @Autowired
    solutions_mapper solutionsMapper;

    @GetMapping("/solution")
    public String select_solution(Model model){
        Page<solution_bean> page = new Page<>(1,30);
        IPage<solution_bean> iPage =solutionsMapper.select_solution(page);
        List<solution_bean> list=iPage.getRecords();
        model.addAttribute("solution",list);
        return "solution";
    }
}
