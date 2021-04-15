package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;
import com.wuhao.wuhaozn_springboot.bean.solution_bean;

public interface solution_ser  {

    public int insert_solution(solution_bean solutionBean);
    public IPage<solution_bean> select_solution(Page page);
    public IPage<solution_bean> select_jub_solution(Page page,String solutionName);
    public boolean delete_id (int id);
    public boolean updateimage(String product_image,int id);
    public solution_bean select_detailpage(String solution_name);
}
