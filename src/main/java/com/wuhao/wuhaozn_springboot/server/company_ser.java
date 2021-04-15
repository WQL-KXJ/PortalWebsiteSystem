package com.wuhao.wuhaozn_springboot.server;

import com.wuhao.wuhaozn_springboot.bean.company_information;

public interface company_ser {

    public company_information select_company();
    public  boolean update_company(company_information companyInformation);
    public company_information select_company_gy(int id);

}
