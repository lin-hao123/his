package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.entity.Register;

public interface RegisterMapper {
	
    Register queryRegisterByNumber(@Param("number") int parameter);
	
	int queryAllCount();
	
	List<Register> queryAllByPage(Map<String, Object> parameter);
	
	int add(Register parameter);

	int update(Register parameter);

	List<Register> queryByPage(Map<String, Object> parameter);

	int queryCount();

	List<Register> queryByDocid(Map<String, Object> parameter);

	int queryDocCount(int parameter);	
}
