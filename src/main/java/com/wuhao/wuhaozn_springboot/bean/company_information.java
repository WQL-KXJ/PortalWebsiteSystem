package com.wuhao.wuhaozn_springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class company_information {
    int id;
    String company_phone;
    String company_place;
    String company_image;
    String company_intro;
    String company_content;
}
