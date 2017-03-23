package com.ujia.enums;

import java.util.ArrayList;
import java.util.List;

import com.ujia.model.EnumObject;

public enum ArticleType {
	PRE_DECORATE("装前必读", 0), MATERIAL_PURCHASE("材料选购", 1), CONSTRUCTION_TECH("施工工艺", 2), DESIGN_COLLOCATION("设计搭配",
			3), UJIA_STORY("U家故事", 4);

	// 成员变量
	private String comment;
	private int value;
	

	// 构造方法
	private ArticleType(String comment, int value) {
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

	public static List<EnumObject> getArticleTypeList() {

		List<EnumObject> enumObjectList = new ArrayList<EnumObject>();
		
		for (ArticleType articleType : ArticleType.values()) {
			EnumObject eo = new EnumObject();
			eo.setKey(articleType.toString());
			eo.setValue(articleType.getComment());

			enumObjectList.add(eo);
		}
		return enumObjectList;
	}
	
	public static ArticleType getArticleTypeByValue(Integer value) {

		for (ArticleType articleType : ArticleType.values()) {
			if (articleType.getValue() == value) {
				return articleType;
			}
		}
		return null;

	}
}
