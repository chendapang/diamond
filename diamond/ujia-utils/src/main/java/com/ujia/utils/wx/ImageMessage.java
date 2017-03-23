package com.ujia.utils.wx;

public class ImageMessage extends BaseMessage {
	
	private Image Image;
	
	

	public ImageMessage() {
		this.setMsgType(com.ujia.enums.MsgType.image.name());
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	

}