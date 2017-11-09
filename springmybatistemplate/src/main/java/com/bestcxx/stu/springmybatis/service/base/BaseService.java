package com.bestcxx.stu.springmybatis.service.base;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
	/**
     * 可写的sqlSession
     */
	@Autowired
    protected SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
