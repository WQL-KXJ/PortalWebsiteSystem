package com.wuhao.wuhaozn_springboot.util;

import org.springframework.util.ClassUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class AuthCode {


    //声明验证码图片的宽度和高度
    private static final int Wind = 100;
    private static final int Hight =40;

    //验证码生成库
    private static final String Code="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    //验证码的字符数量
    private static final int Code_Count=4;

    //干扰线的数量
    private static final int Line_Count=7;

    //干扰点的数量
    private static final int  Dot_Count=(int)(Wind*Hight*0.02);

    public String random_math;

    //创建一个随机数对象
    Random random = new Random();

    //绘制验证码图片的方法(五要素)
    public void getAuthCode() throws FileNotFoundException, IOException {
        //生成验证码图片
        BufferedImage img = new BufferedImage(Wind, Hight, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = img.getGraphics();
        //设置背景颜色
        graphics.setColor(getColor());
        //填充可绘制的区域
        graphics.fillRect(0, 0, Wind, Hight);
        //创建字体对象
        Font font =new Font("黑体",Font.BOLD,25);
        //设置字体
        graphics.setFont(font);

        //循环画四次
        for(int i=0;i<Code_Count;i++) {
            //设置画笔颜色
            graphics.setColor(getColor());
            //从仓库中获取随机字符
            char a = getRandomCode();
            random_math+=a;
            //绘制字符到到图像中
            graphics.drawString(a+"", i*25+5, 30);
        }

        //循环绘制干扰线
        for(int i=0;i<Line_Count;i++) {
            //设置画笔颜色
            graphics.setColor(getColor());

            //确定直线(两点确定一条直线，需要一个起始点和结束点)
            int xStart = random.nextInt(Wind+1);//在大小随机获取起始点中获取点
            int yStart = random.nextInt(Hight+1);
            int xEnd=  random.nextInt(Wind+1);
            int yEnd = random.nextInt(Hight+1);
            //绘制线条到图像中
            graphics.drawLine(xStart, yStart, xEnd, yEnd);
        }

        //绘制干扰点
        for(int i=0;i<Dot_Count;i++) {
            //设置画笔的颜色
            graphics.setColor(getColor());
            int Dot_x = random.nextInt(Wind-1);
            int Dot_y = random.nextInt(Hight-1);
            img.setRGB(Dot_x, Dot_y, getColor().getRGB());

        }
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        String filePath = path + "static/layuimini/images/wql.jpg";
        System.out.println(filePath);
        //通过IO流将图片输出到指定位置
        ImageIO.write(img, "jpg", new FileOutputStream(filePath));
    }

    //获取随机字符的方法
    public  char  getRandomCode() {

        char code= Code.charAt(random.nextInt(61));


        return code;
    }

    //获取随机颜色的方法
    public Color getColor() {


        return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }


}
