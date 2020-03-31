package com.havey.model;

import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

/**
*@描述  生成验证码
*@参数 
*@返回 
*@作者 yehw
*@日期 2020/3/20
*@时间 14:26
*/
@Data
public class VerificationCode {
    //生成验证码是图片类型。
    private int width =100;//图片的宽是100px
    private int height=50;//图片的高度是50px
    private String[] fontNames ={"微软雅黑","宋体","楷体","隶书"};//定义验证码字体
    private Color color =new Color(255,255,255);//背景颜色是白色
    private Random random=new Random();
    private String codes="0123456789"+
            "abcdefghijkmnpqrst";//为了方便用户验证，取消字母l和o。
    private String text;//最后的字符串

   /**
   *@描述 获得随机的一个颜色。让验证码的每一个颜色都不一样
   *@参数
   *@返回
   *@作者 yehw
   *@日期 2020/3/20
   *@时间 14:46
   */
    private Color randomColor(){
        //颜色取值RGB混色。随机。
        int red=random.nextInt(255);
        int green=random.nextInt(255);
        int blue=random.nextInt(255);
        return new Color(red,green,blue);
    }
    
    /**
    *@描述 随机获得一个字体
    *@参数 
    *@返回 
    *@作者 yehw
    *@日期 2020/3/20
    *@时间 14:48
    */
    public Font randomFont(){
        String fontName=fontNames[random.nextInt(fontNames.length)];//从字体数组中随机获得一个字体
        int style=random.nextInt(4);
        int size=random.nextInt(5)+25;//为了防止字体忽大忽小，随机数尽量小一点
        return new Font(fontName,style,size);

    }
    
    /**
    *@描述 获得一个随机的字符串
    *@参数 
    *@返回 
    *@作者 yehw
    *@日期 2020/3/20
    *@时间 14:51
    */
    private char randomChar(){
        return codes.charAt(random.nextInt(codes.length()));
    }

    /**
    *@描述 创建一个BufferImage对象
    *@参数
    *@返回
    *@作者 yehw
    *@日期 2020/3/20
    *@时间 14:52
    */
    private BufferedImage createImgIO(){
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D= (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setColor(color);// 设置验证码图片的背景颜色
        graphics2D.fillRect(0, 0, width, height);
        return bufferedImage;
    }
    
    /**
    *@描述 获得图片
    *@参数 
    *@返回 
    *@作者 yehw
    *@日期 2020/3/20
    *@时间 14:55
    */
    public BufferedImage getImage(){
        BufferedImage image=createImgIO();
        Graphics2D graphics2D= (Graphics2D)image.getGraphics();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            graphics2D.setColor(randomColor());
            graphics2D.setFont(randomFont());
            float x = i * width * 1.0f / 4;
            graphics2D.drawString(s, x, height - 15);
        }
        this.text = sb.toString();//获得文本对象
        drawLine(image);
        return image;
    }
    /**
     *@描述 绘制干扰线
     *@参数
     *@返回
     *@作者 yehw
     *@日期 2020/3/20
     *@时间 14:57
     */
    private void drawLine(BufferedImage image) {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        int num = 5;
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setColor(randomColor());
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
    *@描述 输出图片
    *@参数 [image, out]
    *@返回 void
    *@作者 yehw
    *@日期 2020/3/20
    *@时间 14:57
    */
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

}
