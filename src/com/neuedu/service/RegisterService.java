package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.entity.Register;

public interface RegisterService 
{
    Register queryRegisterByNumber(@Param("number") int parameter);
	
	int queryAllCount();
	
	List<Register> queryAllByPage(Map<String, Object> parameter);
	
	List<Register> queryByPage(Map<String, Object> parameter);
	
	int add(Register parameter);

	int update(Register parameter);

	int queryCount();

	int queryDocCount(@Param("docid")int parameter);
	
	List<Register> queryByDocid(Map<String,Object> parameter);
}
