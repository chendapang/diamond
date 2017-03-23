package com.fisher.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * 使用方法在系统启动时调用方法初始化 
 * 发送对象 RocketProducer.initRocketProducer();
 */
public class RocketProducer {
	private static String producerGroupName = "visitGroup";
	private static String namesrvAddr = "120.77.61.47:9876";
	private static String instanceName = "visitProducer";
	private static DefaultMQProducer defaultRocketProducer;

	// 利用静态内部类特性实现外部类的单例
	private static class RocketProducerBuilder {
		private static RocketProducer rocketProducer = new RocketProducer();

	}

	// 私有化构造函数
	private RocketProducer() {
		defaultRocketProducer = new DefaultMQProducer(producerGroupName);
		defaultRocketProducer.setNamesrvAddr(namesrvAddr);
		defaultRocketProducer.setInstanceName(instanceName);
		try {
			defaultRocketProducer.start();
		} catch (MQClientException e) {

			e.printStackTrace();
		}
	}

	private static RocketProducer getRocketProducer() {
		return RocketProducerBuilder.rocketProducer;
	}

	/**
	 * 初始化rocketmq连接
	 */
	public static void initRocketProducer() {
		getRocketProducer();
	}

	/**
	 * 关闭rocketmq链接
	 */
	public static void shutdown() {
		defaultRocketProducer.shutdown();
	}

	public static void sendMessage(String topic, String tag, byte[] body) {
		try {
			defaultRocketProducer.send(new Message(topic, tag, body));

		} catch (MQClientException e) {

			e.printStackTrace();
		} catch (RemotingException e) {

			e.printStackTrace();
		} catch (MQBrokerException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		initRocketProducer();
		sendMessage("visitService", "getfromMq", ("fuck U555").getBytes());
		// sendMessage("visitService", "TagA", "OrderID001", ("fuck
		// U6").getBytes());
		defaultRocketProducer.shutdown();
	}

}
