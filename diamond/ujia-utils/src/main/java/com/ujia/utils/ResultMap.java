package com.ujia.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
	public static String SUCCESS ="success";//请求的业务是否成功
	public static String errorMSG ="errorMSG";//如果失败，携带信息
	public static String DATA ="data";//数据
	
	public static Map<String,Object> getSuccessResultMap(){
		Map<String,Object> m = new HashMap<>();
		m.put(SUCCESS, true);
		
		return m;
	}
	
	public static Map<String,Object> getFailResultMap(String msg){
		Map<String,Object> m = new HashMap<>();
		m.put(SUCCESS, false);
		m.put(errorMSG, msg);
		return m;
	}
	public static Object getSuccessResultMap(Object data) {
		Map<String,Object> m = new HashMap<>();
		m.put(SUCCESS, true);
		m.put(DATA, data);
		
		return m;
	}
}