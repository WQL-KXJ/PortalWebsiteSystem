package com.wuhao.wuhaozn_springboot.protal_mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.case_bean;
import org.apache.ibatis.annotations.Select;

public interface cases_mapper {

    @Select("select * from case_table")
    public IPage<case_bean> select_case(Page page);
}
