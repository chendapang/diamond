package com.ujia.vo;

import java.util.List;

import com.ujia.model.WxMenuButton;

public class WxMenuButtonVo extends WxMenuButton{
	
	private List<WxMenuButtonVo> sub_button;
	
	

	public String getKey() {
		return this.getuKey();
	}

	public void setKey(String key) {
		this.setuKey(key);
	}

	public String getMedia_id() {
		return this.getMediaId();
	}

	public void setMedia_id(String media_id) {
		this.setMediaId(media_id);
	}

	public List<WxMenuButtonVo> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WxMenuButtonVo> sub_button) {
		this.sub_button = sub_button;
	}
	
}