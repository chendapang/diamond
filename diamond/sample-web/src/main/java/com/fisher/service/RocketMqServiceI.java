package com.fisher.service;

/**
 * 访问服务接口
 * 
 * @author fisher
 *
 */
public interface RocketMqServiceI {

	/**
	 * 发送访问信息到mq
	 * 
	 * @param visit
	 * @throws Exception
	 */
	public void sendToMq() throws Exception;

}