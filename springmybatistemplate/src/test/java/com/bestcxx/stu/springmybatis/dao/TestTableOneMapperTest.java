package com.bestcxx.stu.springmybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

@DirtiesContext  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理    
@Rollback(true)
public class TestTableOneMapperTest {
	
	@Autowired
    protected SqlSession sqlSession;
	
	@Test
	public void testSelectByPrimaryKey(){
		TestTableOneMapper testTableOneMapper=sqlSession.getMapper(TestTableOneMapper.class);
		Integer id=1;
		TestTableOne t=testTableOneMapper.selectByPrimaryKey(id);
		System.out.println("搜索结果:"+t.getComment());
	}

}
