package com.fisher.distributedLock.zk.normal;

import java.util.Date;

public class TestNormalDistributedLock implements Runnable {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			Thread ad = new Thread(new TestNormalDistributedLock());

			ad.start();

		}

	}

	@Override

	public void run() {

		DistributedLock lock = null;

		try {

			System.out.println("线程开启:" + Thread.currentThread().getId());

			// 多个锁用“，” 分隔开

			// lock = new
			// DistributedLock("10.168.128.113:2181,10.168.173.159:2181",
			// "amount");

//			Thread.sleep(1000);

			lock = new DistributedLock("localhost:2181", "testLock");

			lock.lock();

			System.out.println("线程：" + Thread.currentThread().getId() + "在" + new Date().getTime() + "时间获得锁");

//			Thread.sleep(4000);

			System.out.println("===Thread " + Thread.currentThread().getId() + " running");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (lock != null) {

				System.out.println("线程：" + Thread.currentThread().getId() + "在" + new Date().getTime() + "释放锁");

				lock.unlock();

			}

		}

	}
}
