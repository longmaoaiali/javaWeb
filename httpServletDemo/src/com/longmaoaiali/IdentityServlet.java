package com.longmaoaiali;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IdentityServlet extends HttpServlet{
	public static final char[] chars = {'2','3','4','5','6','7','8','9','A','B','C','D','E'};
	public static Random random = new Random();
	
	public static String getRandomString() {
			StringBuffer stringBuffer = new StringBuffer();
			for(int i=0;i<6;i++) {
				stringBuffer.append(chars[random.nextInt(chars.length)]);
			}
		return stringBuffer.toString();
	}

	
	public static Color getColor() {
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));	
	}
	
	public static Color getReverseColor(Color color) {
		return new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		resp.setContentType("image/jpeg");
		String randomString = getRandomString();
		System.out.println("randomString --> "+randomString);
		
		req.getSession(true).setAttribute("randomString", randomString);
		
		int imgHeight = 30;
		int imgWidth = 100;
		
		//背景色与前景色
		Color color = getColor();
		Color colorReversrColor = getReverseColor(color);
		
		BufferedImage bImage= new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bImage.createGraphics();//获取绘图对象
		graphics2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		graphics2d.setColor(color);
		graphics2d.fillRect(0, 0, imgWidth, imgHeight);
		graphics2d.setColor(colorReversrColor);
		graphics2d.drawString(randomString, 18, 20);//绘制字符串
		//绘制随机噪点 最多绘制100次
		for(int i=0,n=random.nextInt(100);i<n;i++)
		{
			graphics2d.drawRect(random.nextInt(imgWidth), random.nextInt(imgHeight), 1, 1);
		}
		
		ServletOutputStream outputStream = resp.getOutputStream();
		//JPEGImageEncoder encoder = JPEGCodec.
	
		ImageIO.write(bImage, "jpg", outputStream);
		outputStream.flush();
	}
	
	
}
