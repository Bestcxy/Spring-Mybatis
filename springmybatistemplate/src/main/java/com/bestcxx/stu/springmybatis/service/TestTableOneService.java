package com.bestcxx.stu.springmybatis.service;

import java.util.Map;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

public interface TestTableOneService {
	/**
	 * 根据id获取实体
	 * @param id
	 * @return
	 */
	TestTableOne selectByPrimaryKey(Integer id);
	
	/**
	 * 分页查询
	 * @return
	 */
	Map<String,Object> getList();
}
