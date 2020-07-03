package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.DepartmentMapper;
import com.neuedu.entity.Department;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	@Qualifier("departmentMapper")  
	private DepartmentMapper mapper;

	@Override
	public int queryAllCount() {
		return mapper.queryAllCount();
	}

	@Override
	public List<Department> queryAllByPage(Map<String, Object> parameter) {
		return mapper.queryAllByPage(parameter);
	}

	@Override
	public int add(Department parameter) {
		return mapper.add(parameter);
	}

	/**
	1、@Transactional注解只能在抛出RuntimeException或者Error时才会触发事务的回滚。
	常见的非RuntimeException是不会触发事务的回滚的，但是我们平时做业务处理时，需要捕获异常。
	所以可以手动抛出RuntimeException异常或者添加rollbackFor = Exception.class(也可以指定相应异常)
	2、在service层showTransactional()方法中捕获异常(try catch)不会触发事务回滚，所以需要在controller层调用方法时捕获异常。
	3、只有public修饰的方法才能使事务生效。
	事物的传播方式Propagation
	REQUIRED：支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。（默认）
	SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行。
	MANDATORY：支持当前事务，如果当前没有事务，就抛出异常。
	REQUIRES_NEW：新建事务，如果当前存在事务，把当前事务挂起
	NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
	NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
	NESTED：支持当前事务，如果当前事务存在，则执行一个嵌套事务，如果当前没有事务，就新建一个事务。

	*/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void showTransactional() {
		// 值的长度超过字段长度，所以插入不成功。
		Department department = new Department();
		department.setName("一二三四五六七八九十十一十二十三十四十五十六十七十八十九二十二十一二十二二十三二十四二十五二十六");
		mapper.add(department);
		department.setName("一二三四五六七八九十十一十二十三十四十五十六十七十八十九二十二十一二十二二十三二十四二十五");
		mapper.add(department);
		
	}


	
}
