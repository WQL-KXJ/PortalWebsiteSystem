package com.wuhao.wuhaozn_springboot.portal_service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.protal_mapper.products_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class product_service_ implements product_service {

    @Autowired
    products_mapper productMapper;

    @Override
    public IPage<product_bean> select_product(Page page) {

      return   productMapper.select_product(page);

    }
}
