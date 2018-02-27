package com.bestcxx.stu.springmybatis.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bestcxx.stu.springmybatis.dao.TestTableOneMapper;
import com.bestcxx.stu.springmybatis.model.TestTableOne;
import com.bestcxx.stu.springmybatis.service.TestTableOneService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(readOnly=true)
public class TestTableOneServiceImpl implements TestTableOneService {

	@Autowired
	private TestTableOneMapper testTableOneMapper;
	
	@Override
	public TestTableOne selectByPrimaryKey(Integer id) {
		return testTableOneMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly=false,isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,timeout=3,rollbackFor=Exception.class)
	public void insert(TestTableOne record) throws SQLException{
		Integer numFlag= testTableOneMapper.insert(record);
		if(numFlag!=1){
			throw new SQLException("保存失败："+record.toString());
		}
	}

	@Override
	public Map<String,Object> getList() {
		Map<String,Object> map=new HashMap<String,Object>();
		int pageNum=10;//查询页序数
		int pageSize=2;//每页数据条数
		boolean flag=false;
		
		//我们有两种方式
		if(flag){
			//第一种，使用插件提供的结果形式,会有较多的冗余字段
			//{"pageNum":-1,"pageSize":2,"size":2,"startRow":1,"endRow":2,
			//"total":6,"pages":3,"list":[{"id":1,"comment":"11"},{"id":2,"comment":"22"}],
			//"prePage":0,"nextPage":0,"isFirstPage":false,"isLastPage":false,
			//"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,
			//"navigatepageNums":[1,2,3],"navigateFirstPage":1,"navigateLastPage":3,
			//"firstPage":1,"lastPage":3}
			PageHelper.startPage(pageNum, pageSize);
			List<TestTableOne> list=testTableOneMapper.getList();
			PageInfo<TestTableOne> pageInfo=new PageInfo<TestTableOne>(list);
			map.put("pageInfo", pageInfo);
		}else{
			//第二种，自己对结果集合进行再次封装，这里可以采用上面的方法重写一个 PageInfo，这里便于理解单独取值
			//{"pageInfo":{"当前页序数":3,"总页数":3,"每页数据大小":2,
			//"list":[{"id":5,"comment":"55"},{"id":6,"comment":"66"}],"数据总数":6}}
			Page<TestTableOne> page=PageHelper.startPage(pageNum, pageSize);
			testTableOneMapper.getList();
			Map<String,Object> map2=new HashMap<String,Object>();
			map2.put("数据总数", page.getTotal());
			map2.put("每页数据大小", page.getPageSize());
			map2.put("当前页序数", page.getPageNum());
			map2.put("总页数", page.getPages());
			map2.put("list", page.getResult());
			map.put("pageInfo", map2);
		}
		
		return map;
	}

	
}
