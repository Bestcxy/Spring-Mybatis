package com.bestcxx.stu.springmybatis.dao;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

/**
 * 测试表 DAP 层
 * test.test_table_one
 * @author WuJieJecket
 *
 */
public interface TestTableOneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTableOne record);

    int insertSelective(TestTableOne record);

    TestTableOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTableOne record);

    int updateByPrimaryKey(TestTableOne record);
}