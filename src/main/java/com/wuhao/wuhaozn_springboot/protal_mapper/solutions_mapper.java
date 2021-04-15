package com.wuhao.wuhaozn_springboot.protal_mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import org.apache.ibatis.annotations.Select;

public interface solutions_mapper {

    @Select("select * from solution_table")
    public IPage<solution_bean> select_solution(Page page);
}
