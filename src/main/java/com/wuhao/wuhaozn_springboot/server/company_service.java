package com.wuhao.wuhaozn_springboot.server;

import com.wuhao.wuhaozn_springboot.bean.company_information;
import com.wuhao.wuhaozn_springboot.mapper.company_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class company_service implements company_ser {
    @Autowired
    company_mapper companyMapper;

    @Override
    public company_information select_company() {



        return companyMapper.select_company();
    }

    @Override
    public boolean update_company(company_information companyInformation) {


        return companyMapper.update_company(companyInformation);
    }

    @Override
    public company_information select_company_gy(int id) {
        return companyMapper.select_company_gy(id);
    }
}
