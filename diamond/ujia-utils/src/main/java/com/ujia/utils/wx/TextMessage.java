package com.ujia.utils.wx;


public class TextMessage extends BaseMessage
{
  private String Content;

  public TextMessage()
  {
    this.setMsgType(com.ujia.enums.MsgType.text.name());
  }

  public String getContent()
  {
    return this.Content;
  }

  public void setContent(String content) {
    this.Content = content;
  }
}