package com.wxhl.edu.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wxhl.edu.repository.RequestRespostory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class TestOne {
	@Autowired
	private RequestRespostory requestRespostoryp;
	
	@Test
	public void test1(){
		Map<String,String> map = requestRespostoryp.getAllWord(null);
		System.out.println(map);
	}
	
	@Test
	public void test2(){
		requestRespostoryp.saveOrUpdate("testTwo", "success");
	}
	
	@Test
	public void test3(){
		requestRespostoryp.deleteWord("testTwo");
	}
}
