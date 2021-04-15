package com.wuhao.wuhaozn_springboot.mapper;

import com.wuhao.wuhaozn_springboot.bean.company_information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface company_mapper {

    @Select("select * from company_information")
    public company_information select_company();

    @Update("update company_information set company_phone=#{company_phone},company_place=#{company_place},company_intro=#{company_intro},company_image=#{company_image},company_content=#{company_content} where id=1")
    public  boolean update_company(company_information companyInformation);

    @Select("select * from company_information where id=#{id}")
    public company_information select_company_gy(int id);
}
