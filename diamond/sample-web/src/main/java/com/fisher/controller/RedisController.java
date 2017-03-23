package com.fisher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 工单资源入口
 * 
 * @author yxc
 *
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 预约设计
	 * 
	 * @param response
	 * @param course
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void reservation(HttpServletResponse response,HttpServletRequest request)
			throws Exception {
		request.getSession();
		ValueOperations operations = redisTemplate.opsForValue();
		operations.set("tt", "123");
		System.out.println(operations.get("tt"));
//        String key = "XXX";
//        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(key);

	}
	

}
