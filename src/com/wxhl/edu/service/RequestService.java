package com.wxhl.edu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxhl.edu.repository.RequestRespostory;

@Service
public class RequestService {
	@Autowired
	private RequestRespostory requestRespostory;
	
	public boolean saveOrUpdate(String key,String value){
		return requestRespostory.saveOrUpdate(key, value);
	}
	public boolean deleteWord(String key){
		return requestRespostory.deleteWord(key);
	}
	public Map<String,String> getAll(String key){
		return requestRespostory.getAllWord(key);
	}
}
