package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.mapper.case_mapper;
import com.wuhao.wuhaozn_springboot.mapper.patents_mapper;
import com.wuhao.wuhaozn_springboot.mapper.solution_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class solution_service implements solution_ser {
    @Autowired
    solution_mapper solutionMapper;
    @Override
    public int insert_solution(solution_bean solutionBean) {
        int code= solutionMapper.insert_solution(solutionBean);

        return code;
    }
    @Override
    public IPage<solution_bean> select_solution(Page page) {

        return solutionMapper.select_page(page);
    }

    @Override
    public IPage<solution_bean> select_jub_solution(Page page, String solutionName) {


        return solutionMapper.select_jub_page(page,solutionName);
    }

    @Override
    public boolean delete_id(int id) {

        boolean tf=solutionMapper.delete_id(id);
        return tf;
    }
    @Override
    public boolean updateimage(String product_image,int id){

        return solutionMapper.update_image_name(product_image,id);

    }

    @Override
    public solution_bean select_detailpage(String solution_name) {
        return solutionMapper.select_detailpage(solution_name);
    }
}
