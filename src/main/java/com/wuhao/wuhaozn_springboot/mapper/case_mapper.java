package com.wuhao.wuhaozn_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import org.apache.ibatis.annotations.*;

public interface case_mapper extends BaseMapper<case_bean> {
    @Insert("insert into case_table(case_name,case_brief,case_image,case_content) values (#{case_name},#{case_brief},#{case_image},#{case_content})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int insert_case(case_bean caseBean);

    @Select("select * from case_table")
    public IPage<case_bean> select_page(Page page);

    @Select("select * from case_table where case_name=#{caseName}")
    public  IPage<case_bean> select_jub_page(Page page,String caseName);

    @Delete("delete from case_table where id=#{id}")
    public boolean delete_id(int id);

    @Update("update case_table set case_image=#{case_image} where id=#{id}")
    public boolean update_image_name(String case_image,int id);

    //详情页
    @Select("select * from case_table where case_name=#{case_name}")
    public case_bean select_detailpage(String case_name);
}
