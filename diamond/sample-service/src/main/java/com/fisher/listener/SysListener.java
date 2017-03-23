package com.fisher.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.InitializingBean;

import com.fisher.rocketmq.RocketConsumer;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

public class SysListener implements ServletContextListener, InitializingBean {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			
			//用于通知motan框架服务已经可以接收请求
			MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
			
			// 初始化mq消费对象
			RocketConsumer.initRocketPushConsumer();

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

}
