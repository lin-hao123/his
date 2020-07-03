package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neuedu.dao.MedicineMapper;
import com.neuedu.entity.Medicine;

@Service("medicineServiceImpl")
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	@Qualifier("medicineMapper")  
	private MedicineMapper mapper;

	@Override
	public int queryAllCount() {
		return mapper.queryAllCount();
	}

	@Override
	public List<Medicine> queryAllByPage(Map<String, Object> parameter) {
		return mapper.queryAllByPage(parameter);
	}

	@Override
	public int add(Medicine parameter) {
		return mapper.add(parameter);
	}

}
