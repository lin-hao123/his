package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.entity.Prescription;
import com.neuedu.entity.Register;

public interface PrescriptionService {
	

	int queryAllCount(@Param("rid")int parameter);
	
	List<Prescription> queryAllByPage(Map<String, Object> parameter);

	int add(Prescription parameter);
	
	int queryDocCount(@Param("docid")int parameter);
	
	List<Register> queryByDocid(Map<String,Object> parameter);
	
}
