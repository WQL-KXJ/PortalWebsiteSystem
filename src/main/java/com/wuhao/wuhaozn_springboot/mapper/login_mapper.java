package com.wuhao.wuhaozn_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhao.wuhaozn_springboot.bean.login_bean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface login_mapper extends BaseMapper<login_bean> {

    @Select("select * from admin where username=#{username}")
    public login_bean select_admin_name(String username);

    @Update("update admin set password=#{password_new} where password=#{password_yuan}")
    public boolean updata_admin(String password_new,String password_yuan);

    @Insert("insert into admin (username,password,remark) values (#{username},#{password},#{remark})")
    public boolean insert_admin(String username,String password,String remark);

    @Update("update admin set username=#{username_new},remark=#{remark} where username=#{username_old}")
    public boolean updata_admin_username(String username_new,String username_old,String remark);

    @Select("select (remark) from admin where username=#{username}")
    public String select_admin_remark(String username);
}
