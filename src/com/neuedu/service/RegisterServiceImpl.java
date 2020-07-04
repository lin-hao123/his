package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neuedu.dao.RegisterMapper;
import com.neuedu.entity.Register;

@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	@Qualifier("registerMapper")  
	private RegisterMapper mapper;
	@Override
	public Register queryRegisterByNumber(int parameter) {
		// TODO Auto-generated method stub
		return mapper.queryRegisterByNumber(parameter);
	}

	@Override
	public int queryAllCount() {
		// TODO Auto-generated method stub
		return mapper.queryAllCount();
	}

	@Override
	public List<Register> queryAllByPage(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return mapper.queryAllByPage(parameter);
	}

	@Override
	public int add(Register parameter) {
		// TODO Auto-generated method stub
		return  mapper.add(parameter);
	}

}
