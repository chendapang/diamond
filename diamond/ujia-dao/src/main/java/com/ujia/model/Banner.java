package com.ujia.model;

import java.util.Date;

public class Banner {
	private String id;

	private Date createdAt;

	private String bannerName;

	private Date updatedAt;

	private String bannerDatas;

	private String bannerKey;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName == null ? null : bannerName.trim();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getBannerDatas() {
		return bannerDatas;
	}

	public void setBannerDatas(String bannerDatas) {
		this.bannerDatas = bannerDatas == null ? null : bannerDatas.trim();
	}

	public String getBannerKey() {
		return bannerKey;
	}

	public void setBannerKey(String bannerKey) {
		this.bannerKey = bannerKey;
	}

}