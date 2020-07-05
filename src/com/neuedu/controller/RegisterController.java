package com.neuedu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.entity.Department;
import com.neuedu.entity.Doctor;
import com.neuedu.entity.Medicine;
import com.neuedu.entity.Register;
import com.neuedu.service.DoctorService;
import com.neuedu.service.RegisterService;
import com.neuedu.tool.PageTool;

@Controller
@RequestMapping("/register") 
public class RegisterController {
	@Autowired
	@Qualifier("doctorServiceImpl")
	private DoctorService doctorService;

	@Autowired
	@Qualifier("registerServiceImpl")
	private RegisterService registerService;
	
	@RequestMapping("/list")
	public String list(String strPageIndex, String strPageSize, Model model){
		
		int pageIndex = PageTool.getPageIndex(strPageIndex, model);  
		
		int pageSize = PageTool.getPageSize(strPageSize, model);
		
		int dataCount = registerService.queryAllCount();  
		
		PageTool.setPageCount(pageSize, dataCount, model);
		
		Map<String, Object> mapParameter = new HashMap<String, Object>(); 
		
		List<Doctor> listDoct = doctorService.queryByPage(mapParameter);  
		
		model.addAttribute("listDoct",listDoct);
		
		PageTool.setStartIndex(pageSize, pageIndex, mapParameter);
		
		List<Register> list = registerService.queryAllByPage(mapParameter); 
		
		model.addAttribute("list",list);
		
		return "register";
	}
	@RequestMapping("/list2")
	public String list2(String strPageIndex, String strPageSize, Model model){
		int pageIndex = PageTool.getPageIndex(strPageIndex, model);  
		
		int pageSize = PageTool.getPageSize(strPageSize, model);
		
		int dataCount = registerService.queryAllCount();  
		
		PageTool.setPageCount(pageSize, dataCount, model);
		
		Map<String, Object> mapParameter = new HashMap<String, Object>(); 
		
		List<Register> list = registerService.queryAllByPage(mapParameter);  
		
		model.addAttribute("list",list);
		
		PageTool.setStartIndex(pageSize, pageIndex, mapParameter);
		
		List<Doctor> listDoct = doctorService.queryByPage(mapParameter); 
		
		model.addAttribute("listDoct",listDoct);
		
		return "register2";
	}
	@RequestMapping("/list3")
	public String list3(String strPageIndex, String strPageSize, Model model){
		int pageIndex = PageTool.getPageIndex(strPageIndex, model);  
		
		int pageSize = PageTool.getPageSize(strPageSize, model);
		
		int dataCount = registerService.queryAllCount();  
		
		PageTool.setPageCount(pageSize, dataCount, model);
		
		Map<String, Object> mapParameter = new HashMap<String, Object>(); 
		
		List<Register> list = registerService.queryAllByPage(mapParameter);  
		
		model.addAttribute("list",list);
		
		PageTool.setStartIndex(pageSize, pageIndex, mapParameter);
		
		List<Doctor> listDoct = doctorService.queryByPage(mapParameter); 
		
		model.addAttribute("listDoct",listDoct);
		
		return "register3";
	}
	@RequestMapping("/list4")
	public String list4(String strPageIndex, String strPageSize, Model model){
		int pageIndex = PageTool.getPageIndex(strPageIndex, model);  
		
		int pageSize = PageTool.getPageSize(strPageSize, model);
		
		int dataCount = registerService.queryAllCount();  
		
		PageTool.setPageCount(pageSize, dataCount, model);
		
		Map<String, Object> mapParameter = new HashMap<String, Object>(); 
		
		List<Register> list = registerService.queryAllByPage(mapParameter);  
		
		model.addAttribute("list",list);
		
		PageTool.setStartIndex(pageSize, pageIndex, mapParameter);
		
		List<Doctor> listDoct = doctorService.queryByPage(mapParameter); 
		
		model.addAttribute("listDoct",listDoct);
		
		return "register4";
	}
	@RequestMapping("/add")
	public String add(Register parameter){
		registerService.add(parameter);
		return "redirect:/register/list";
	}

}
