package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping("/list2/{id}")
	public String list2(@PathVariable int id,String strPageIndex, String strPageSize, Model model){
		
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
		
		return "prescription2";
		
	}
	@RequestMapping("/add/{id}")
	public String add(@PathVariable int id,Prescription parameter)
	{
		parameter.getRegister().setId(id);
		prescriptionService.add(parameter);
		return "redirect:/prescription/list/{id}";
	}
	
	@RequestMapping("/update/{id}")
	public void update(@PathVariable int id,Prescription parameter,HttpServletResponse response)
	{
		
		int medicineCount;
		medicineCount=prescriptionService.medCount(parameter);
		System.out.println(medicineCount);
		parameter.setId(id);
		try {
			if(medicineCount>0)
			{
				prescriptionService.update(parameter);
				response.getWriter().print(medicineCount);
			}
			else
			{
				response.getWriter().print(0);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}


}
