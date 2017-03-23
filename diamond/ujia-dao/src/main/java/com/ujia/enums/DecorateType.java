package com.ujia.enums;

import java.util.ArrayList;
import java.util.List;

import com.ujia.model.EnumObject;

public enum DecorateType {
	JAPAN_TYPE("日式", 0), NORTHERN_EUROPE("北欧", 1), MODERN("现代", 2), LIGHT_AMERICAN("轻美式", 3), MASHUP("混搭",
			4), LIGHT_INDUSTRY("轻工业", 5);
	// 成员变量
	private String comment;
	private int value;

	// 构造方法
	private DecorateType(String comment, int value) {
		this.comment = comment;
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public static String getComment(int value) {
		String commentStr = null;
		for (DecorateType decorateType : DecorateType.values()) {
			if (decorateType.value == value) {
				commentStr = decorateType.comment;
				break;
			}
		}
		return commentStr;
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

	public static List<EnumObject> getDecorateTypeList() {
		List<EnumObject> enumObjectList = new ArrayList<EnumObject>();
		for (DecorateType decorateType : DecorateType.values()) {
			EnumObject eo = new EnumObject();
			eo.setKey(decorateType.toString());
			eo.setValue(decorateType.getComment());

			enumObjectList.add(eo);
		}
		return enumObjectList;
	}

	public static DecorateType getDecorateTypeByValue(Integer value) {

		for (DecorateType decorateType : DecorateType.values()) {
			if (decorateType.getValue() == value) {
				return decorateType;
			}
		}
		return null;

	}

}
