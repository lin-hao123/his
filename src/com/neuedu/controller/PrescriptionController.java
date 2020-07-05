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


import com.neuedu.entity.Prescription;
import com.neuedu.service.PrescriptionService;
import com.neuedu.tool.PageTool;

@Controller
@RequestMapping("/prescription") 
public class PrescriptionController 
{
	@Autowired
	@Qualifier("prescriptionServiceImpl")
	private PrescriptionService prescriptionService;
	
	
	@RequestMapping("/list/1")
	public String list(String strPageIndex, String strPageSize, Model model){
		
		int pageIndex = 1;
		if(strPageIndex != null && strPageIndex.matches("\\d+")) { pageIndex = Integer.parseInt(strPageIndex);}
		model.addAttribute("pageIndex", pageIndex);
		int pageSize = 2;
		if(strPageSize != null && strPageIndex.matches("\\d+")) {pageSize = Integer.parseInt(strPageSize);}
		
		model.addAttribute("pageSize", pageSize);
		int dataCount = prescriptionService.queryAllCount();
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
		List<Prescription> list = prescriptionService.queryAllByPage(mapParameter);  
		model.addAttribute("list",list);
		return "prescription";
	}

}
