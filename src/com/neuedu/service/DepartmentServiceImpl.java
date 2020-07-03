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
	1��@Transactionalע��ֻ�����׳�RuntimeException����Errorʱ�Żᴥ������Ļع���
	�����ķ�RuntimeException�ǲ��ᴥ������Ļع��ģ���������ƽʱ��ҵ����ʱ����Ҫ�����쳣��
	���Կ����ֶ��׳�RuntimeException�쳣�������rollbackFor = Exception.class(Ҳ����ָ����Ӧ�쳣)
	2����service��showTransactional()�����в����쳣(try catch)���ᴥ������ع���������Ҫ��controller����÷���ʱ�����쳣��
	3��ֻ��public���εķ�������ʹ������Ч��
	����Ĵ�����ʽPropagation
	REQUIRED��֧�ֵ�ǰ���������ǰû�����񣬾��½�һ���������������ѡ�񡣣�Ĭ�ϣ�
	SUPPORTS��֧�ֵ�ǰ���������ǰû�����񣬾��Է�����ʽִ�С�
	MANDATORY��֧�ֵ�ǰ���������ǰû�����񣬾��׳��쳣��
	REQUIRES_NEW���½����������ǰ�������񣬰ѵ�ǰ�������
	NOT_SUPPORTED���Է�����ʽִ�в����������ǰ�������񣬾Ͱѵ�ǰ�������
	NEVER���Է�����ʽִ�У������ǰ�����������׳��쳣��
	NESTED��֧�ֵ�ǰ���������ǰ������ڣ���ִ��һ��Ƕ�����������ǰû�����񣬾��½�һ������

	*/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void showTransactional() {
		// ֵ�ĳ��ȳ����ֶγ��ȣ����Բ��벻�ɹ���
		Department department = new Department();
		department.setName("һ�����������߰˾�ʮʮһʮ��ʮ��ʮ��ʮ��ʮ��ʮ��ʮ��ʮ�Ŷ�ʮ��ʮһ��ʮ����ʮ����ʮ�Ķ�ʮ���ʮ��");
		mapper.add(department);
		department.setName("һ�����������߰˾�ʮʮһʮ��ʮ��ʮ��ʮ��ʮ��ʮ��ʮ��ʮ�Ŷ�ʮ��ʮһ��ʮ����ʮ����ʮ�Ķ�ʮ��");
		mapper.add(department);
		
	}


	
}
