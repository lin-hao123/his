package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.entity.Prescription;

public interface PrescriptionService {
	

	int queryAllCount();
	
	List<Prescription> queryAllByPage(Map<String, Object> parameter);
	


}
