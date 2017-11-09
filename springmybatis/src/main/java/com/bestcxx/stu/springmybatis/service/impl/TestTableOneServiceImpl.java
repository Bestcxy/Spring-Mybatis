package com.bestcxx.stu.springmybatis.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bestcxx.stu.springmybatis.dao.TestTableOneMapper;
import com.bestcxx.stu.springmybatis.model.TestTableOne;
import com.bestcxx.stu.springmybatis.service.TestTableOneService;

@Service
@Transactional(readOnly=true)
public class TestTableOneServiceImpl implements TestTableOneService {

	@Autowired
	private TestTableOneMapper testTableOneMapper;
	
	@Override
	public TestTableOne selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return testTableOneMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly=false,isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,timeout=3,rollbackFor=Exception.class)
	public void insert(TestTableOne record) throws SQLException{
		Integer numFlag= testTableOneMapper.insert(record);
		if(numFlag!=1){
			throw new SQLException("保存失败："+record.toString());
		}
	}

	
}
