package com.ujia.model;

import java.math.BigDecimal;

public class Construction {
	private String id;

	private String projectName;

	private Double lat;

	private Double lng;

	private String address;

	private String constuctionStatus;
	private Integer area;
	private BigDecimal cost;
	private String picCover;
	private Integer picAmount;
	private String picUrls;

	public String getConstuctionStatus() {
		return constuctionStatus;
	}

	public void setConstuctionStatus(String constuctionStatus) {
		this.constuctionStatus = constuctionStatus;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getPicCover() {
		return picCover;
	}

	public void setPicCover(String picCover) {
		this.picCover = picCover;
	}

	public String getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getPicAmount() {
		return picAmount;
	}

	public void setPicAmount(Integer picAmount) {
		this.picAmount = picAmount;
	}

}