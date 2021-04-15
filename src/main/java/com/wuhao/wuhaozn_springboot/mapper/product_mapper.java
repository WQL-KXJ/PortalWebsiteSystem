package com.wuhao.wuhaozn_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.product_bean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface product_mapper extends BaseMapper<product_bean> {

        @Insert("insert into product_table(product_name,product_brief,product_image,product_content) values (#{product_name},#{product_brief},#{product_image},#{product_content})")
        @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
        public int insert_product(product_bean product);

        @Select("select * from product_table")
        public IPage<product_bean> select_page(Page page);

        @Select("select * from product_table where product_name=#{productName}")
        public  IPage<product_bean> select_jub_page(Page page,String productName);

        @Delete("delete from product_table where id=#{id}")
        public boolean delete_id(int id);

        @Update("update product_table set product_image=#{product_image} where id=#{id}")
        public boolean update_image_name(String product_image,int id);

        //详情页
        @Select("select * from product_table where product_name=#{product_name}")
        public product_bean select_detailpage(String product_name);

        @Select("select * from product_table")
        public List<product_bean> select_product();
}
