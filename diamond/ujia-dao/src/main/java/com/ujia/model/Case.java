package com.ujia.model;

import java.util.Date;

public class Case {
	private String id;
	private String buildingName;
	private String tag;
	private String houseStyle;
	private String houseArea;
	private String costAmount;
	private String designerName;
	private String designerAvatar;
	private Date createdAt;
	private Integer type;

	private String caption;

	private String pageUrl;
	private String coverUrl;

	private Date updatedAt;

	private String context;

	private String author;
	private Integer recommend;

	private String caseAbstract;
	
	private String recommendStr;
	private String typeStr;
	private String topCover;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getHouseStyle() {
		return houseStyle;
	}

	public void setHouseStyle(String houseStyle) {
		this.houseStyle = houseStyle;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getCostAmount() {
		return costAmount;
	}

	public void setCostAmount(String costAmount) {
		this.costAmount = costAmount;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getDesignerAvatar() {
		return designerAvatar;
	}

	public void setDesignerAvatar(String designerAvatar) {
		this.designerAvatar = designerAvatar;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getCaseAbstract() {
		return caseAbstract;
	}

	public void setCaseAbstract(String caseAbstract) {
		this.caseAbstract = caseAbstract;
	}

	public String getRecommendStr() {
		return recommendStr;
	}

	public void setRecommendStr(String recommendStr) {
		this.recommendStr = recommendStr;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public String getTopCover() {
		return topCover;
	}

	public void setTopCover(String topCover) {
		this.topCover = topCover;
	}

}