package com.ujia.enums;

public enum MsgType {
	
	
	
	text("文字", 0),news("图文消息", 1),image("图片", 1),voice("语音", 1),video("视频", 1);
	// 成员变量
	private String comment;
	private int value;

	// 构造方法
	private MsgType(String comment, int value) {
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
