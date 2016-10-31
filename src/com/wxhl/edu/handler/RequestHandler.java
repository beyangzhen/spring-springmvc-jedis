package com.wxhl.edu.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wxhl.edu.service.RequestService;

@Controller
@Scope("prototype") 
public class RequestHandler {
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/toQuery")
	public  String toQuery(@RequestParam(value="my_key", required=false)String my_key, Map<String,Object> map){
		Map<String, String> words = requestService.getAll(my_key);
		map.put("wordList", words);
		return "index"	;
	}
	
	@RequestMapping("/saveWord")
	public String saveWord(@RequestParam(value="word_key")String word_key, @RequestParam(value="word_value")String word_value){
		requestService.saveOrUpdate(word_key, word_value);
		return "redirect:/toQuery";
	}
	@RequestMapping("/deleteKey/{key}")
	public String deleteWord(@PathVariable("key") String key){
		requestService.deleteWord(key);
		return "redirect:/toQuery";
	}
}
