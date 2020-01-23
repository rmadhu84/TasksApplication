package com.madhu.spring.tasks.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class TaskApplicationConfiguration{

    @Bean
	public HashMap<String, String> getTestMap1(){
		Map<String, String> map = new HashMap<String, String>();
        map.put("a", "Apple");
        map.put("b", "Ball");
		return (HashMap<String, String>) map;		
	}
}