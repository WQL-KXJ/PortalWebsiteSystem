package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import com.wuhao.wuhaozn_springboot.mapper.product_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class product_service  implements product_ser{

    @Autowired
    product_mapper productMapper;

    @Override
    public int insert_product(product_bean productBean) {

        int code= productMapper.insert_product(productBean);

       return code;
    }

    @Override
    public IPage<product_bean> select_product(Page page) {

        return productMapper.select_page(page);
    }

    @Override
    public IPage<product_bean> select_jub_product(Page page, String productName) {


        return productMapper.select_jub_page(page,productName);
    }

    @Override
    public boolean delete_id(int id) {

        boolean tf=productMapper.delete_id(id);
        return tf;
    }
    @Override
    public boolean updateimage(String product_image,int id){

       return productMapper.update_image_name(product_image,id);

    }

    @Override
    public product_bean select_detailpage(String product_name) {

        return productMapper.select_detailpage(product_name);
    }

    @Override
    public List<product_bean> select_product() {
        return productMapper.select_product();
    }

}
