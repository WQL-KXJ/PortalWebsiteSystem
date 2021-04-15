package com.wuhao.wuhaozn_springboot.portal_service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.protal_mapper.solutions_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class solution_service_ implements solution_service {
    @Autowired
    solutions_mapper solutionsMapper;

    @Override
    public IPage<solution_bean> select_solution(Page page) {

        return solutionsMapper.select_solution(page);
    }
}
