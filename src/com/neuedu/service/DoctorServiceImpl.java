package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neuedu.dao.DoctorMapper;
import com.neuedu.entity.Doctor;

@Service("doctorServiceImpl")

public class DoctorServiceImpl implements DoctorService {

	@Autowired
	@Qualifier("doctorMapper")  
	private DoctorMapper mapper;

	
	@Override
	public Doctor queryDoctorByUsername(String username) {
		return mapper.queryDoctorByUsername(username);
	}

	@Override
	public int queryAllCount() {
		return mapper.queryAllCount();
	}

	@Override
	public List<Doctor> queryAllByPage(Map<String, Object> parameter) {
		return mapper.queryAllByPage(parameter);
	}

	@Override
	public int add(Doctor parameter) {
		return mapper.add(parameter);
	}

	@Override
	public List<Doctor> queryByPage(Map<String, Object> parameter) {
		return mapper.queryByPage(parameter);
	}

}
