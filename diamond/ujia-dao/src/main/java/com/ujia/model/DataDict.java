package com.ujia.model;

public class DataDict {

	/**
	 * id
	 */
	private String id;
	/**
	 * 父类id
	 */
	private String parentDictId;

	/**
	 * 键
	 */
	private String dictKey;
	/**
	 * 值
	 */
	private String dictValue;
	/**
	 * 描述
	 */
	private String dictComment;
	
	

	public DataDict() {
		super();
	}

	public DataDict(String parentDictId, String dictKey, String dictValue, String dictComment) {
		super();
		this.parentDictId = parentDictId;
		this.dictKey = dictKey;
		this.dictValue = dictValue;
		this.dictComment = dictComment;
	}

	public String getParentDictId() {
		return parentDictId;
	}

	public void setParentDictId(String parentDictId) {
		this.parentDictId = parentDictId;
	}

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	public String getDictComment() {
		return dictComment;
	}

	public void setDictComment(String dictComment) {
		this.dictComment = dictComment;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}