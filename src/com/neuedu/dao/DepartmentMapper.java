package com.neuedu.dao;
import java.util.List; 
import java.util.Map;
import com.neuedu.entity.Department;

public interface DepartmentMapper {
	
	int queryAllCount();
	
	List<Department> queryAllByPage(Map<String, Object> parameter);
	
	int add(Department parameter); 
	
}