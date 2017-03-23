package com.fisher.rocketmq;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 使用方法在系统启动时调用方法初始化
 * RocketConsumer.initRocketPushConsumer();
 * 
 * @author fisher
 *
 */
public class RocketConsumer {
	private static String producerGroupName = "visitGroup";
	private static String namesrvAddr = "120.77.61.47:9876";
	private static String instanceName = "visitConsumer";
	private static DefaultMQPushConsumer defaultRocketPushConsumer;
	private static String topic = "rocketMqService";
	private static String tag = "getfromMq";

	// 利用静态内部类特性实现外部类的单例
	private static class RocketConsumerBuilder {
		private static RocketConsumer rocketConsumer = new RocketConsumer();

	}

	// 私有化构造函数
	private RocketConsumer() {
		defaultRocketPushConsumer = new DefaultMQPushConsumer(producerGroupName);
		defaultRocketPushConsumer.setNamesrvAddr(namesrvAddr);
		defaultRocketPushConsumer.setInstanceName(instanceName);

		try {/**
				 * 订阅指定topic下tags分别等于TagA或TagC或TagD 两个参数：第一个参数是topic第二个参数是tags
				 */
			defaultRocketPushConsumer.subscribe(topic, tag);
			defaultRocketPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
				@Override
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
						ConsumeConcurrentlyContext consumeConcurrentlyContext) {
					MessageExt messageExt = msgs.get(0);

					WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

					Object classObj = wac.getBean(messageExt.getTopic());

					Class clazz = classObj.getClass();
					Method method;
					try {
						method = clazz.getMethod(messageExt.getTags(), byte[].class);
						method.invoke(classObj, messageExt.getBody());
					} catch (NoSuchMethodException e) {

						e.printStackTrace();
					} catch (SecurityException e) {

						e.printStackTrace();
					} catch (IllegalAccessException e) {

						e.printStackTrace();
					} catch (IllegalArgumentException e) {

						e.printStackTrace();
					} catch (InvocationTargetException e) {

						e.printStackTrace();
					}

					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});

			defaultRocketPushConsumer.start();
		} catch (MQClientException e) {

			e.printStackTrace();
		}
	}

	private static RocketConsumer getRocketPushConsumer() {
		return RocketConsumerBuilder.rocketConsumer;
	}

	/**
	 * 初始化rocketmq连接
	 */
	public static void initRocketPushConsumer() {
		getRocketPushConsumer();
	}

	public static void main(String[] args) {
		initRocketPushConsumer();
	}

}
