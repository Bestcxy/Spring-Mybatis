package com.bestcxx.stu.springmybatis.service;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

public interface TestTableOneService {
	/**
	 * 根据id获取实体
	 * @param id
	 * @return
	 */
	TestTableOne selectByPrimaryKey(Integer id);
}
