package com.wuhao.wuhaozn_springboot.control;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.wuhao.wuhaozn_springboot.server.login_server;
import com.wuhao.wuhaozn_springboot.util.AuthCode;
import com.wuhao.wuhaozn_springboot.util.StateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import sun.nio.ch.IOUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class login_control {

    @Autowired
    private Producer producer;

    @Autowired
    login_server loginServer;

    static  String code;

    @GetMapping({"/login"})
    public String login_wql(HttpServletRequest request){

    return "page/login";

}
    @PostMapping({"/login"})
    @ResponseBody
    public StateUtil login_fq(HttpServletRequest request,@RequestParam("username") String name, @RequestParam("password") String password,@RequestParam("authcode") String authcode) {

        Subject subject = SecurityUtils.getSubject();
        String authcodes=code;
        UsernamePasswordToken usernamePasswordToken =new UsernamePasswordToken(name,password);
        String remark = loginServer.select_admin_remark(name);
        if(authcodes.equals(authcode)){
        try {
            subject.login(usernamePasswordToken);
            HttpSession session = request.getSession();
            session.setAttribute("username",name);
            session.setAttribute("password",password);
            session.setAttribute("remark",remark);
            return  new StateUtil("登录成功",200);
        }catch (UnknownAccountException e){
            System.out.println("用户名错误！");

        }catch (IncorrectCredentialsException a){
            System.out.println("密码错误！");
        }}else {
            System.out.println("验证码错误！");
            return new StateUtil("验证码错误！",310);
        }
        return new StateUtil("登录失败",400);
    }

    @GetMapping("/authcode.jpg")
    public void authcode(HttpServletResponse response,HttpServletRequest request) throws IOException {

        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpg");
        //验证码的内容
        String text=producer.createText();
        code=text;
        //生成图片
        BufferedImage image =  producer.createImage(text);
        HttpSession session = request.getSession();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ImageIO.write(image,"jpg",servletOutputStream);
        IOUtils.closeQuietly(servletOutputStream);
    }

    @GetMapping("/loginout")
    @ResponseBody
    public StateUtil loginout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return new StateUtil("退出成功",200);
    }

    @PostMapping("/loginupdate")
    @ResponseBody
    public  StateUtil update_admin(@RequestParam("password_new") String password_new,@RequestParam("password_yuan") String password_yuan) {

       boolean code_state= loginServer.update_admin(password_new,password_yuan);

        if(code_state){
            return  new StateUtil("更改成功",200);
        }
       return  new StateUtil("更改失败",400);
    }


    @PostMapping("/logininsert")
    @ResponseBody
    public  StateUtil insert_admin(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("remark") String remark){

        boolean code_state = loginServer.insert_admin(username,password,remark);

        if(code_state){
            return  new StateUtil("添加成功",200);
        }
        return  new StateUtil("添加失败",400);
    }



    @PostMapping("/user_username")
    @ResponseBody
    public StateUtil updata_admin(@RequestParam("username_new") String username_new,@RequestParam("username_old") String username_old,@RequestParam("remark") String remark){

       boolean a= loginServer.updata_username(username_new,username_old,remark);
       if(a){
           return new StateUtil("更新成功！",200);

       }
       return  new StateUtil("更新失败！",400);

    }




    @GetMapping("/user_password_updata")
    public  String user_password_updata(){


        return "page/user_password";
    }

    @GetMapping("/add_admin")
    public  String add_admin(){


        return "page/form_step";
    }
}
