package com.wxhl.edu.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
public class RequestRespostory {
	@Autowired
	private JedisPool jedisPool;
	
	/*
	 * �����е���Ϣ
	 * */
	public Map<String,String> getAllWord(String myKey){
		Jedis jedis = jedisPool.getResource();
		String pattern = null;
		if(myKey==null || "".equals(myKey)){
			pattern = "*";
		}else{
			pattern = "*" + myKey + "*";
		}
		Set<String> keys = jedis.keys(pattern);
		Map<String ,String > resultMap = new HashMap<>();
		for(String key: keys){
			resultMap.put(key, jedis.get(key));
		}
		jedis.close();
		return resultMap;
	}
	
	/*
	 * �����͸���
	 * **/
	public boolean saveOrUpdate(String key, String value){
		Jedis jedis = jedisPool.getResource();
		String status = jedis.set(key, value);
		System.out.println("status>>>" + status); 
		jedis.close();
		return (status.equals("OK"))?true:false;
	}
	
	/*
	 * ɾ��
	 * */
	public boolean deleteWord(String key){
		Jedis jedis = jedisPool.getResource();
		long index = jedis.del(key);
		System.out.println("index>>>" + index); 
		jedis.close(); 
		return (index ==1 )?true:false;
	}
}
