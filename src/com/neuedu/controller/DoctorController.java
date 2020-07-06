package com.neuedu.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.entity.Department;
import com.neuedu.entity.Doctor;
import com.neuedu.service.DepartmentService;
import com.neuedu.service.DoctorService;
import com.neuedu.tool.PageTool;

@Controller
@RequestMapping("/doctor") 

public class DoctorController {

	@Autowired
	@Qualifier("doctorServiceImpl")
	private DoctorService doctorService;

	@Autowired
	@Qualifier("departmentServiceImpl")
	private DepartmentService departmentService;
	
	@RequestMapping("/login")
	public String login(String username, String password, Model model, HttpSession session){  
		if(username!=null&&username.length()>0  &&password!=null  &&password.length()>0) {
			Doctor doctor = doctorService.queryDoctorByUsername(username);
			if(doctor==null||!password.equals(doctor.getPassword()))
			{
			model.addAttribute("msg","1");
			}
			else
			{
			session.setAttribute("loginDoctor", doctor);
				if(doctor.getDepartment().getId()==1) 
				{   
				//综管科医生登录
				return "redirect:/department/list";
				}
				else if(doctor.getDepartment().getId()==2) 
				{
				//药房科医生登录
				return "redirect:/medicine/list";
				}
				else 
				{
				return "redirect:/register/list3/"+String.valueOf(doctor.getId());
				}
			}
		}else {
			//用户名或密码无效
			model.addAttribute("msg","0");
		}
		return "signin";
	}
	
	@RequestMapping("/loginout")
	public String loginout(HttpSession session){
		session.removeAttribute("loginDoctor");
		return "signin";
	}

	@ResponseBody
	@RequestMapping("/checkUsername")
	public void checkUsername(String username, HttpServletResponse response, HttpSession session){
		try {
			if(username!=null && username.length()>0) {
				Doctor doctor = doctorService.queryDoctorByUsername(username);  if(doctor==null){
					response.getWriter().print(false);
				}else{
					response.getWriter().print(true);
				}
			}else {  
				response.getWriter().print("error");
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/list")
	public String list(String strPageIndex, String strPageSize, Model model){
		
	int pageIndex = PageTool.getPageIndex(strPageIndex, model);  
	
	int pageSize = PageTool.getPageSize(strPageSize, model);
	
	int dataCount = doctorService.queryAllCount();  
	
	PageTool.setPageCount(pageSize, dataCount, model);
	
	Map<String, Object> mapParameter = new HashMap<String, Object>(); 
	
	List<Department> listDept = departmentService.queryAllByPage(mapParameter);  
	
	model.addAttribute("listDept",listDept);
	
	PageTool.setStartIndex(pageSize, pageIndex, mapParameter);
	
	List<Doctor> listDoct = doctorService.queryAllByPage(mapParameter); 
	
	model.addAttribute("listDoct",listDoct);
	
	return "doctor";
	
	}
	
	@RequestMapping("/add")
	
	public String add(Doctor parameter){  
		doctorService.add(parameter);
	
	return "redirect:/doctor/list";
	}
}
