package com.neuedu.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptorTool implements HandlerInterceptor {

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception { 
		if(request.getRequestURI().contains("/static/")) { // 访问静态资源 
			return true; 
		} 
		if(request.getRequestURI().contains("/signin.jsp")) { // 前往登录页面 
			return true; 
		} 
		if(request.getRequestURI().contains("checkUsername")) { // 验证登录账号 
			return true; 
		} 
		if(request.getRequestURI().contains("login")) { // 进行登录操作 
			return true; 
		} 
		HttpSession session = request.getSession(); 
		if(session.getAttribute("loginDoctor")!=null) { // 已登录 
			return true; 
		} 
		//request.getRequestDispatcher(request.getContextPath()+"/jsp/signin.jsp").forward(request, response); 
		response.sendRedirect(request.getContextPath()+"/jsp/signin.jsp"); 
		return false; 
		}
	
	
}

	
	
	
