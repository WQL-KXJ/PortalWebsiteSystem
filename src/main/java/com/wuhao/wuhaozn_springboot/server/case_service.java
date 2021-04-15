package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.mapper.case_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class case_service implements case_ser {

    @Autowired
    case_mapper caseMapper;


    @Override
    public int insert_case(case_bean caseBean) {
        int code =caseMapper.insert_case(caseBean);
        return code;
    }

    @Override
    public IPage<case_bean> select_case(Page page) {

        return caseMapper.select_page(page);
    }

    @Override
    public IPage<case_bean> select_jub_case(Page page, String caseName) {


        return caseMapper.select_jub_page(page,caseName);
    }

    @Override
    public boolean delete_id(int id) {

        boolean tf=caseMapper.delete_id(id);
        return tf;
    }
    @Override
    public boolean updateimage(String product_image,int id){

        return caseMapper.update_image_name(product_image,id);

    }

    @Override
    public case_bean select_detailpage(String case_name) {
        return caseMapper.select_detailpage(case_name);
    }
}
