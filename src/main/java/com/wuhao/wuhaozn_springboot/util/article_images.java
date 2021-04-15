package com.wuhao.wuhaozn_springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class article_images {
    /*{
  "code": 0 //0表示成功，其它失败
  ,"msg": "" //提示信息 //一般上传失败后返回
  ,"data": {
    "src": "图片路径"
    ,"title": "图片名称" //可选}}*/

    int code;
    String msg;
    data_util data;



}
