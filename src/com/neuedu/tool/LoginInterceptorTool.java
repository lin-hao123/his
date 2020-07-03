package com.neuedu.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptorTool implements HandlerInterceptor {

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception { 
		if(request.getRequestURI().contains("/static/")) { // ���ʾ�̬��Դ 
			return true; 
		} 
		if(request.getRequestURI().contains("/signin.jsp")) { // ǰ����¼ҳ�� 
			return true; 
		} 
		if(request.getRequestURI().contains("checkUsername")) { // ��֤��¼�˺� 
			return true; 
		} 
		if(request.getRequestURI().contains("login")) { // ���е�¼���� 
			return true; 
		} 
		HttpSession session = request.getSession(); 
		if(session.getAttribute("loginDoctor")!=null) { // �ѵ�¼ 
			return true; 
		} 
		//request.getRequestDispatcher(request.getContextPath()+"/jsp/signin.jsp").forward(request, response); 
		response.sendRedirect(request.getContextPath()+"/jsp/signin.jsp"); 
		return false; 
		}
	
	
}

	
	
	
