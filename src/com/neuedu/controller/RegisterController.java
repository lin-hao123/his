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
		int pageIndex = 1;
		if(strPageIndex != null && strPageIndex.matches("\\d+")) { pageIndex = Integer.parseInt(strPageIndex);}
		model.addAttribute("pageIndex", pageIndex);
		int pageSize = 2;
		if(strPageSize != null && strPageIndex.matches("\\d+")) {pageSize = Integer.parseInt(strPageSize);}
		
		model.addAttribute("pageSize", pageSize);
		int dataCount = registerService.queryAllCount();
		int pageCount;
		if(dataCount % pageSize == 0) {pageCount = dataCount / pageSize;}
		else {pageCount = (dataCount / pageSize)+ 1;}
		
		model.addAttribute("pageCount", pageCount);
		List<String> listStringPage = new ArrayList<String>();
		for (int i = 1; i <= pageCount; i++) {listStringPage.add(String.valueOf(i));}
		
		model.addAttribute("listStringPage", listStringPage);
		Map<String, Object> mapParameter = new HashMap<String, Object>();
		int startIndex = (pageIndex - 1) * pageSize;
		mapParameter.put("startIndex", startIndex);  
		mapParameter.put("pageSize", pageSize);
		List<Register> list = registerService.queryAllByPage(mapParameter);  
		model.addAttribute("list",list);
		List<Doctor> listDoct = doctorService.queryByPage(mapParameter);  
		model.addAttribute("listDoct",listDoct);
		return "register";
	}
	@RequestMapping("/add")
	public String add(Register parameter){
		registerService.add(parameter);
		return "redirect:/register/list";
	}

}
