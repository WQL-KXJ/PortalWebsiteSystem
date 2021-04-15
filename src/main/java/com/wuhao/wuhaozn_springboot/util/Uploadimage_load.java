package com.wuhao.wuhaozn_springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Uploadimage_load {
    String statename;
    String imagefile_path;
    int  statecode;
}
