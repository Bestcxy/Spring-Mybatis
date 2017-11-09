package com.bestcxx.stu.springmybatis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bestcxx.stu.springmybatis.dao.TestTableOneMapper;
import com.bestcxx.stu.springmybatis.model.TestTableOne;
import com.bestcxx.stu.springmybatis.service.TestTableOneService;
import com.bestcxx.stu.springmybatis.service.base.BaseService;

@Service
@Transactional(readOnly=true)
public class TestTableOneServiceImpl extends BaseService implements
		TestTableOneService {
	
	@Override
	public TestTableOne selectByPrimaryKey(Integer id){
		TestTableOneMapper testTableOneMapper = sqlSession.getMapper(TestTableOneMapper.class);
		TestTableOne testTableOne=testTableOneMapper.selectByPrimaryKey(id);
		System.out.println("搜索内容："+testTableOne.getComment());
		return testTableOne;
		
	}
}
