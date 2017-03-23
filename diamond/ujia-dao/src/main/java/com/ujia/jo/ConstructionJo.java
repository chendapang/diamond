package com.ujia.jo;

import java.util.ArrayList;
import java.util.List;

import com.ujia.model.Construction;

public class ConstructionJo extends Construction {
	private List<String> picUrlList = new ArrayList<String>();

	public List<String> getPicUrlList() {
		return picUrlList;
	}

	public void setPicUrlList(List<String> picUrlList) {
		this.picUrlList = picUrlList;
	}

}