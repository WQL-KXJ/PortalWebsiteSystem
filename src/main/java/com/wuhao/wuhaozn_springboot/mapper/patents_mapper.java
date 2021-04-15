package com.wuhao.wuhaozn_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface patents_mapper extends BaseMapper<patents_bean> {

    @Insert("insert into patents_table(patents_name,patents_brief,patents_image,patents_content) values (#{patents_name},#{patents_brief},#{patents_image},#{patents_content})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int insert_patents(patents_bean patents);

    @Select("select * from patents_table")
    public IPage<patents_bean> select_page(Page page);

    @Select("select * from patents_table where patents_name=#{patentsName}")
    public  IPage<patents_bean> select_jub_page(Page page,String patentsName);

    @Delete("delete from patents_table where id=#{id}")
    public boolean delete_id(int id);

    @Update("update patents_table set patents_image=#{patents_image} where id=#{id}")
    public boolean update_image_name(String patents_image,int id);

    //详情页
    @Select("select * from patents_table where patents_name=#{patents_name}")
    public patents_bean select_detailpage(String patents_name);

    @Select("select * from patents_table")
    public List<patents_bean> select_patents();
}
