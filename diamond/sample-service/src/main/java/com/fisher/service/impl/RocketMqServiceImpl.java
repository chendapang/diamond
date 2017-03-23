package com.fisher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisher.dao.SampleMapper;
import com.fisher.service.RocketMqServiceI;

/**
 * 工单服务实现类
 */
@Service("rocketMqService")
public class RocketMqServiceImpl implements RocketMqServiceI {
	@Autowired
	private SampleMapper sampleMapper;

	@Override
	public void getfromMq(byte[] bytes) throws Exception {
		System.out.println(new String(bytes));
		System.out.println("========"+sampleMapper.sampleTest());
//		String visit = JSONObject.parseObject(new String(bytes), String.class);
	}

}