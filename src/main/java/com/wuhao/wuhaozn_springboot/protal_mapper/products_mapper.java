package com.wuhao.wuhaozn_springboot.protal_mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface products_mapper extends BaseMapper<product_bean> {

    @Select("select * from product_table")
    public IPage<product_bean> select_product(Page page);


}
