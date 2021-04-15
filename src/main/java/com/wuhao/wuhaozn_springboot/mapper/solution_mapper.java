package com.wuhao.wuhaozn_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import org.apache.ibatis.annotations.*;

public interface solution_mapper extends BaseMapper<solution_bean> {

    @Insert("insert into solution_table(solution_name,solution_brief,solution_image,solution_content) values (#{solution_name},#{solution_brief},#{solution_image},#{solution_content})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int insert_solution(solution_bean solution);

    @Select("select * from solution_table")
    public IPage<solution_bean> select_page(Page page);

    @Select("select * from solution_table where solution_name=#{solutionName}")
    public  IPage<solution_bean> select_jub_page(Page page,String solutionName);

    @Delete("delete from solution_table where id=#{id}")
    public boolean delete_id(int id);
   
    @Update("update solution_table set solution_image=#{solution_image} where id=#{id}")
    public boolean update_image_name(String solution_image,int id);

    //详情页
    @Select("select * from solution_table where solution_name=#{solution_name}")
    public solution_bean select_detailpage(String solution_name);
}
