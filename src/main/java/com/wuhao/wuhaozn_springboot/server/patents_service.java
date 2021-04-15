package com.wuhao.wuhaozn_springboot.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.bean.patents_bean;
import com.wuhao.wuhaozn_springboot.mapper.patents_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patents_service implements  patents_ser {
    @Autowired
    patents_mapper patentsMapper;

    @Override
    public int insert_patents(patents_bean patentsBean) {

        int code =patentsMapper.insert_patents(patentsBean);
        return code;
    }
    @Override
    public IPage<patents_bean> select_patents(Page page) {

        return patentsMapper.select_page(page);
    }

    @Override
    public IPage<patents_bean> select_jub_patents(Page page, String patentsName) {


        return patentsMapper.select_jub_page(page,patentsName);
    }

    @Override
    public boolean delete_id(int id) {

        boolean tf=patentsMapper.delete_id(id);
        return tf;
    }
    @Override
    public boolean updateimage(String product_image,int id){


        return patentsMapper.update_image_name(product_image,id);

    }

    @Override
    public patents_bean select_detailpage(String patents_name) {
        return patentsMapper.select_detailpage(patents_name);
    }

    @Override
    public List<patents_bean> select_patents() {
        return patentsMapper.select_patents();
    }

}
