package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.case_bean;

public interface case_ser {

    public int insert_case(case_bean caseBean);
    public IPage<case_bean> select_case(Page page);
    public IPage<case_bean> select_jub_case(Page page,String caseName);
    public boolean delete_id (int id);
    public boolean updateimage(String product_image,int id);
    public case_bean select_detailpage(String case_name);
}
