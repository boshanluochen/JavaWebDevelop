package com.helloweenvsfei.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentityServlet extends HttpServlet{
	
	private static final long serialVersionUID = -5529969719291872719L;
	//随机字符字典，不包括难辨认的字符
	public static final char[] CHARS = 
		{ 
			'2', '3', '4', '5', '6', '7', '8','9', 'A', 
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 
			'L', 'M','N', 'P', 'Q', 'R', 'S', 'T', 'U', 
			'V', 'W', 'X', 'Y', 'Z' 
		};
	//随机数
	public static Random random = new Random();
	//获取6位随机数
	public static String getRandomString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 6; i++){
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	//获取随机的颜色
	public static Color getRandomColor(){
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	//获取某颜色的反色
	public static Color getReverseColor(Color c){
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置输出类型
		response.setContentType("image/jpeg");
		String randomString = getRandomString();
		//放到session中
		request.getSession(true).setAttribute("randomString", randomString);
		
		int width = 100;
		int height = 30;
		//随机颜色，用于背景色
		Color color = getRandomColor();
		//反色，用于前景色
		Color reverse = getReverseColor(color);
		//创建彩色图片
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取绘图对象
		Graphics2D g = bi.createGraphics();
		//设置字体
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		//设置颜色
		g.setColor(color);
		//绘制背景
		g.fillRect(0, 0, width, height);
		//设置背景颜色
		g.setColor(reverse);
		//绘制随机字符
		g.drawString(randomString, 18, 20);
		//100个随机噪点数
		for (int i = 0; i < random.nextInt(100); i++){
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		//转成JPEG格式
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "JPEG", out);
		out.flush();
	}
}
