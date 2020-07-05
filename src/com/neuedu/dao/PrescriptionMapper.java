package com.neuedu.dao;

import java.util.List;
import java.util.Map;



import com.neuedu.entity.Prescription;


public interface PrescriptionMapper {
	

	List<Prescription> queryAllByPage(Map<String, Object> parameter);

	int queryAllCount();
	
	int add(Prescription parameter);	

}
