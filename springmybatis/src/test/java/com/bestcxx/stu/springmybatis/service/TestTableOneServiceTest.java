package com.bestcxx.stu.springmybatis.service;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.stu.springmybatis.model.TestTableOne;

@DirtiesContext  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理    
@Rollback(true)
public class TestTableOneServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private TestTableOneService testTableOneService;
	
	@Test
	public void testSelectByPrimaryKey(){
		Integer id=1;
		TestTableOne t=testTableOneService.selectByPrimaryKey(id);
		System.out.println("搜索结果："+t.getComment());
	}
	
	@Test
	public void testInsert(){
		Integer id=1;
		TestTableOne record=new TestTableOne();
		record.setId(34);
		record.setComment("测试");
		try {
			testTableOneService.insert(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
