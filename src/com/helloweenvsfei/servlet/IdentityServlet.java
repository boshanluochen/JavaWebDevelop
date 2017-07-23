package com.helloweenvsfei.servlet;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentityServlet extends HttpServlet{
	
	private static final long serialVersionUID = -5529969719291872719L;
	public static final char[] CHARS = 
		{ 
			'2', '3', '4', '5', '6', '7', '8','9', 'A', 
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 
			'L', 'M','N', 'P', 'Q', 'R', 'S', 'T', 'U', 
			'V', 'W', 'X', 'Y', 'Z' 
		};
	public static Random random = new Random();
	public static String getRandomString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 6; i++){
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	public static Color getRandomColor(){
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	public static Color getReverseColor(Color c){
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String randomString = getRandomString();
		request.getSession(true).setAttribute("randomString", randomString);
	}
}
