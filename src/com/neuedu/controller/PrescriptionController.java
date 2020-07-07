package com.neuedu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.entity.Doctor;
import com.neuedu.entity.Medicine;
import com.neuedu.entity.Prescription;
import com.neuedu.entity.Register;
import com.neuedu.service.DoctorService;
import com.neuedu.service.MedicineService;
import com.neuedu.service.PrescriptionService;
import com.neuedu.service.RegisterService;
import com.neuedu.tool.PageTool;

@Controller
@RequestMapping("/prescription") 
public class PrescriptionController 
{
	@Autowired
	@Qualifier("prescriptionServiceImpl")
	private PrescriptionService prescriptionService;
	
	@Autowired
	@Qualifier("medicineServiceImpl")
	private MedicineService medicineService;
	
	@Autowired
	@Qualifier("registerServiceImpl")
	private RegisterService registerService;
	
	@RequestMapping("/list/{id}")
	public String list(@PathVariable int id,String strPageIndex, String strPageSize, Model model){
		
		int pageIndex = PageTool.getPageIndex(strPageIndex, model);  
		
		int pageSize = PageTool.getPageSize(strPageSize, model);
		
		int dataCount = prescriptionService.queryAllCount(id);  
		
		PageTool.setPageCount(pageSize, dataCount, model);
		
		Map<String, Object> mapParameter = new HashMap<String, Object>(); 
		
		model.addAttribute("regiid",id);
		
		List<Medicine> listMedi = medicineService.queryAllByPage(mapParameter);  
		
		model.addAttribute("listMedi",listMedi);
		
		mapParameter.put("rid", id);
		
		PageTool.setStartIndex(pageSize, pageIndex, mapParameter);
		
		List<Prescription> list = prescriptionService.queryAllByPage(mapParameter); 
		
		model.addAttribute("list",list);
		
		return "prescription";
		
	}
	@RequestMapping("/add/{id}")
	public String add(@PathVariable int id,Prescription parameter)
	{
		parameter.getRegister().setId(id);
		prescriptionService.add(parameter);
		return "redirect:/prescription/list/{id}";
	}

}
