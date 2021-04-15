package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuhao.wuhaozn_springboot.bean.product_bean;

import java.util.List;

public interface product_ser {

    public int insert_product(product_bean productBean);
    public IPage<product_bean> select_product(Page page);
    public IPage<product_bean> select_jub_product(Page page,String productName);
    public boolean delete_id (int id);
    public boolean updateimage(String product_image,int id);
    public product_bean select_detailpage(String product_name);
    public List<product_bean> select_product();
}
