package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.entity.Prescription;
import com.neuedu.entity.Register;


public interface PrescriptionMapper {
	

	List<Prescription> queryAllByPage(Map<String, Object> parameter);

	int queryAllCount(int parameter);
	
	int add(Prescription parameter);	
	


}
