package com.ujia.enums;

public enum OrderType {
	ORDER_NORMAL("普通", 0),ORDER_DESIGNER("预约设计师", 1),ORDER_BUILD("预约看工地", 2);
	// 成员变量
	private String comment;
	private int value;

	// 构造方法
	private OrderType(String comment, int value) {
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
}
