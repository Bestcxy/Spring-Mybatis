package com.bestcxx.stu.springmybatis.dao;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.BeforeClass;
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
public class TestTableOneMapperTest  extends AbstractTransactionalJUnit4SpringContextTests{
/*	public class TestTableOneMapperTest extends AbstractTransactionalJUnit4SpringContextTests{
*/	
	@Autowired
	private TestTableOneMapper testTableOneMapper;
	
	@BeforeClass
	public void testBefore(){
		System.out.println("Spring结合mybatis 测试过程遇到的问题总结：\n"
				+ "1、注意mybatis-config-Spring.xml中Mapper类和文件分来了，"
				+ "故采取第一种方式配置文件\n"
				+ "2、Dao层的测试类不能继承 AbstractTransactionalJUnit4SpringContextTests，否则会报错");
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		Integer id=1;
		TestTableOne testTableOne=testTableOneMapper.selectByPrimaryKey(id);
		TestCase.assertEquals("期待搜索结果不为空，但是搜索结果为空", true,testTableOne!=null );
		
	}
}
