package com.bestcxx.stu.springmybatis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestcxx.stu.springmybatis.model.TestTableOne;
import com.bestcxx.stu.springmybatis.service.TestTableOneService;

@RestController
public class HomeController {
	
	@Autowired
	private TestTableOneService testTableOneService;
	
	/**
	 * Controller 访问案例,根据id访问数据库
	 * http://localhost:8085/springmybatis/
	 * @return
	 */
	@RequestMapping("/home")
	public Map<String,Object> home(){
		Map<String,Object> map=new HashMap<String,Object>();
		int id=10000;
		TestTableOne testTableOne=testTableOneService.selectByPrimaryKey(id);
		if(testTableOne!=null){
			map.put("result", "success");
			map.put("data", testTableOne);					
		}else{			
			map.put("result", "error");
		}
		return map;
		
	}
	
	/**
	 * Controller 访问案例，分页搜索
	 * http://localhost:8085/springmybatis/page
	 * 为了便于理解分页，分页参数设定和结果处理都在Service层
	 * @return
	 */
	@RequestMapping("/page")
	public Map<String,Object> pageHelp(){
		return testTableOneService.getList();
	}
	
	
	
}
