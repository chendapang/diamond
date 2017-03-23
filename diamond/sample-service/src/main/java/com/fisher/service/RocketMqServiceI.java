package com.fisher.service;

/**
 * 访问服务接口
 * 
 * @author fisher
 *
 */
public interface RocketMqServiceI {

	/**
	 * 从mq获取访问信息
	 * 
	 * @param visit
	 * @throws Exception
	 */
	public void getfromMq(byte[] bytes) throws Exception;

}