package com.app.TDD.demo;

import java.util.HashMap;
import java.util.Map;

public class ProductSearch {

	private Map<String,Integer>getProductdata(){
		Map<String,Integer> productMap =new HashMap<>();
		productMap.put("TestNg", 20);
		productMap.put("selenium", 15);
		productMap.put("JDBC", 10);
		productMap.put("JUNIT", 15);
		return productMap;
		
	}
	
	
	public int getProduct(String course) {
		// TODO Auto-generated method stub
		Map<String, Integer> populationMap = null ;
		int count =0;
		
		if(course.isEmpty())
		{
			throw new NullPointerException("Course name cannot be empty");
		}
		populationMap = getProductdata();
		
		if(!populationMap.containsKey(course))
		{
			throw new NullPointerException("Course name doesnot exist");
		}
		else {
		count = populationMap.get(course);
		}
		return count;
		
	}

}
