package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neuedu.dao.PrescriptionMapper;
import com.neuedu.entity.Prescription;
import com.neuedu.entity.Register;

@Service("prescriptionServiceImpl")
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	@Qualifier("prescriptionMapper")  
	private PrescriptionMapper mapper;
	


	@Override
	public List<Prescription> queryAllByPage(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return mapper.queryAllByPage(parameter);
	}



	@Override
	public int queryAllCount() {
		// TODO Auto-generated method stub
		return mapper.queryAllCount();
	}



	@Override
	public int add(Prescription parameter) {
		// TODO Auto-generated method stub
		return mapper.add(parameter);
	}



	@Override
	public int queryDocCount(int parameter) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Register> queryByDocid(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return null;
	}



}
