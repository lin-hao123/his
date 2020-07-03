package com.neuedu.service;

import java.util.List; 
import java.util.Map;
import com.neuedu.entity.Department;  

public interface DepartmentService {

	int queryAllCount();
	
	List<Department> queryAllByPage(Map<String, Object> parameter);
	
	int add(Department parameter);
	
	void showTransactional();
	
}
