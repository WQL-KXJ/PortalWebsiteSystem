package com.wuhao.wuhaozn_springboot.portal_service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;

public interface case_service {
    public IPage<case_bean> select_case(Page page);
}
