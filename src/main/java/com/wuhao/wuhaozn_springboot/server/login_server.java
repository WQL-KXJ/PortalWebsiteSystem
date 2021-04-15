package com.wuhao.wuhaozn_springboot.server;

import com.wuhao.wuhaozn_springboot.bean.login_bean;
import com.wuhao.wuhaozn_springboot.mapper.login_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class login_server {

    @Autowired
    login_mapper loginMapper;


    public login_bean get_login(String username){

        login_bean loginBean = loginMapper.select_admin_name(username);

        return loginBean;
    }

    public boolean update_admin(String password_new,String password_yuan){

        return loginMapper.updata_admin(password_new,password_yuan);
    }


    public  boolean insert_admin(String username,String password,String remark){


        return loginMapper.insert_admin(username,password,remark);
    }

    public  boolean updata_username(String username_new,String username_old,String remark) {


        return loginMapper.updata_admin_username(username_new,username_old,remark);
    }

    public  String select_admin_remark(String useranem){

        return loginMapper.select_admin_remark(useranem);

    }

    }

