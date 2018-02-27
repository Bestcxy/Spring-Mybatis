package com.bestcxx.stu.springmybatis.dao;

import java.util.List;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

public interface TestTableOneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTableOne record);

    int insertSelective(TestTableOne record);

    TestTableOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTableOne record);

    int updateByPrimaryKey(TestTableOne record);
    
    List<TestTableOne> getList();
}