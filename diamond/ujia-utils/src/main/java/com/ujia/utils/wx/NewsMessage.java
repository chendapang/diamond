package com.ujia.utils.wx;

import java.util.List;

public class NewsMessage extends BaseMessage {
	private int ArticleCount;
	private List<Article> Articles;
	
	

	public NewsMessage() {
		this.setMsgType(com.ujia.enums.MsgType.news.name());
	}

	public int getArticleCount() {
		return this.ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		this.ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		ArticleCount = Articles.size();
		return this.Articles;
	}

	public void setArticles(List<Article> articles) {
		this.Articles = articles;
	}
}