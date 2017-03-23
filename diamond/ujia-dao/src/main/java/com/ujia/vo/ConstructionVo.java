package com.ujia.vo;

import java.util.ArrayList;
import java.util.List;

import com.ujia.model.Construction;

public class ConstructionVo extends Construction {
	private List<String> picUrlList = new ArrayList<String>();

	public List<String> getPicUrlList() {
		return picUrlList;
	}

	public void setPicUrlList(List<String> picUrlList) {
		this.picUrlList = picUrlList;
	}

	@Override
	public void setPicUrls(String picUrls) {
		String[] picUrlArray = picUrls.split(";");

		for (int i = 0; i < picUrlArray.length; i++) {
			picUrlList.add(picUrlArray[i]);
		}

	}

	@Override
	public String getPicUrls() {
		
		return null;
	}

}