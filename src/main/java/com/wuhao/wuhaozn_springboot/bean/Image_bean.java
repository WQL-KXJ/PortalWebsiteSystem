package com.wuhao.wuhaozn_springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Image_bean {
    int id;
    String image_name;
    String image_type;
    String image_to;
    int image_to_id;

}
