package com.ujia.virgo.controller.jo;

import com.ujia.model.Order;

public class OrderJo extends Order {
	private String fromPage;
	private String fromCase;

	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}

	public String getFromCase() {
		return fromCase;
	}

	public void setFromCase(String fromCase) {
		this.fromCase = fromCase;
	}

}