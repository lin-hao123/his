package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.Medicine;

public interface MedicineMapper {
	int queryAllCount();
	
	List<Medicine> queryAllByPage(Map<String,Object>parameter);
	
	int add(Medicine paremeter);
}
