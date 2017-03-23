package com.fisher.service.impl;

import org.springframework.stereotype.Service;

import com.fisher.rocketmq.RocketProducer;
import com.fisher.service.RocketMqServiceI;

/**
 * 工单服务实现类
 */
@Service("rocketMqService")
public class RocketMqServiceImpl implements RocketMqServiceI {

	@Override
	public void sendToMq() throws Exception {

		// topic 第一个参数是要调用的类实例名称，tag 第二个参数表示是要调用方法
		RocketProducer.sendMessage("rocketMqService", "getfromMq", "55555yxc1111111111".getBytes());
	}

}