package com.ujia.enums;

public enum OrderStatus {
	NOT_HANDLE("未处理", 0), HANDLE("已处理", 1);
	// 成员变量
	private String comment;
	private int value;

	// 构造方法
	private OrderStatus(String comment, int value) {
		this.comment = comment;
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static OrderStatus getOrderStatusByValue(Integer value) {

		for (OrderStatus orderStatus : OrderStatus.values()) {
			if (orderStatus.getValue() == value) {
				return orderStatus;
			}
		}
		return null;

	}
}
