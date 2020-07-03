package com.neuedu.service;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.Doctor;

public interface DoctorService {

	Doctor queryDoctorByUsername(String username);  
	
	int queryAllCount();
	
	List<Doctor> queryAllByPage(Map<String, Object> parameter);  
	
	int add(Doctor parameter);

	List<Doctor> queryByPage(Map<String, Object> parameter);

}
