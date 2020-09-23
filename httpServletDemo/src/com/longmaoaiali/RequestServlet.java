package com.longmaoaiali;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.vm.ci.meta.Local;

public class RequestServlet extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String authTypeString = req.getAuthType();
		String localAddrString  =req.getLocalAddr();
		String localName = req.getLocalName();
		int localPort = req.getLocalPort();//tomcat端口
		int remoteClientPort = req.getRemotePort();
		
		Locale locale = req.getLocale();
		String remoteAddrString = req.getRemoteAddr(); //得到客户端IP
		int serverPort = req.getServerPort();
		
		System.out.println("doPost: local remotePort serverPort "+ localPort+" "+remoteClientPort+" "+serverPort);
		
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String authTypeString = req.getAuthType();
		String localAddrString  =req.getLocalAddr();
		String localName = req.getLocalName();
		int localPort = req.getLocalPort();//tomcat端口
		int remoteClientPort = req.getRemotePort();
		
		Locale locale = req.getLocale();
		String remoteAddrString = req.getRemoteAddr(); //得到客户端IP
		int serverPort = req.getServerPort();
		
		System.out.println("doGet: local remotePort serverPort "+ localPort+" "+remoteClientPort+" "+serverPort);
	}

}

