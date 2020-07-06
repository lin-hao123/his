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

	@Override
	public int update(Register parameter) {
		// TODO Auto-generated method stub
		return  mapper.update(parameter);
	}

	@Override
	public List<Register> queryByPage(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return mapper.queryByPage(parameter);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return mapper.queryCount();
	}

	@Override
	public int queryDocCount(int parameter) {
		// TODO Auto-generated method stub
		return mapper.queryDocCount(parameter);
	}

	@Override
	public List<Register> queryByDocid(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return mapper.queryByDocid(parameter);
	}

}
