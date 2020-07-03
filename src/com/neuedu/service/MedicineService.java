package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.Medicine;

public interface MedicineService {
	
	int queryAllCount();
	
	List<Medicine> queryAllByPage(Map<String,Object>parameter);
	
	int add(Medicine paremeter);
}
