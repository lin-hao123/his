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
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.entity.Department;
import com.neuedu.service.DepartmentService;

@Controller
@RequestMapping("/department")  
public class DepartmentController {
	
	@Autowired
	@Qualifier("departmentServiceImpl")
	private DepartmentService departmentService;

	@RequestMapping("/list")
	public String list(String strPageIndex, String strPageSize, Model model){
		int pageIndex = 1;
		if(strPageIndex != null && strPageIndex.matches("\\d+")) { pageIndex = Integer.parseInt(strPageIndex);}
		model.addAttribute("pageIndex", pageIndex);
		int pageSize = 2;
		if(strPageSize != null && strPageIndex.matches("\\d+")) {pageSize = Integer.parseInt(strPageSize);}
		
		model.addAttribute("pageSize", pageSize);
		int dataCount = departmentService.queryAllCount();
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
		List<Department> list = departmentService.queryAllByPage(mapParameter);  
		model.addAttribute("list",list);
		return "department";
	}

	@RequestMapping("/add")
	public String add(Department parameter){
		departmentService.add(parameter);
		return "redirect:/department/list";
	}
	@ResponseBody
	@RequestMapping("/st")  
	public void st(){
		try {  departmentService.showTransactional();
		}
		catch (Exception e) {
			//e.printStackTrace();
		}
	}


}
