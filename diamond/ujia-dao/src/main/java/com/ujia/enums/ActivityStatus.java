package com.ujia.enums;

public enum ActivityStatus {

	newest("最新活动", 0), boutique("精选活动", 1), to_start("即将开始", 2), finish("已下线", 3);

	private int value;
	private String comment;

	private ActivityStatus(String comment, int value) {
		this.value = value;
		this.comment = comment;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
