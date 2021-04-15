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
public class case_bean {
    int id;
    String case_name;
    String case_brief;
    String case_image;
    String case_content;
}
