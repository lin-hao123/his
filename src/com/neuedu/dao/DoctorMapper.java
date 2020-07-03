package com.neuedu.dao;
import java.util.List; 
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.neuedu.entity.Doctor;

public interface DoctorMapper {
	
	Doctor queryDoctorByUsername(@Param("username") String parameter);
	
	int queryAllCount();
	
	List<Doctor> queryAllByPage(Map<String, Object> parameter);
	
	int add(Doctor parameter);
	
	List<Doctor> queryByPage(Map<String, Object> parameter);
	
}