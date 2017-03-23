package com.ujia.lion.model;

import java.util.ArrayList;
import java.util.List;

public class NavModel {
	
	private String id;
	private String title;
	private String icon;
	private String href;
	private List<NavModel> children = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<NavModel> getChildren() {
		return children;
	}
	public void setChildren(List<NavModel> children) {
		this.children = children;
	}
	
	
	
	
}