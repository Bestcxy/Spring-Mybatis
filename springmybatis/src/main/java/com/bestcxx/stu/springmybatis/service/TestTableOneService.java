package com.bestcxx.stu.springmybatis.service;

import java.sql.SQLException;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

public interface TestTableOneService {
	/**
	 * 根据 id 搜索
	 * @param id
	 * @return
	 */
	TestTableOne selectByPrimaryKey(Integer id);
	
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	void insert(TestTableOne record) throws SQLException;
}
