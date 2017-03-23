package com.fisher.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.InitializingBean;

import com.fisher.rocketmq.RocketProducer;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

public class SysListener implements ServletContextListener, InitializingBean {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			// 初始化mQ发送对象
			RocketProducer.initRocketProducer();
			//初始化motan
			MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

}
