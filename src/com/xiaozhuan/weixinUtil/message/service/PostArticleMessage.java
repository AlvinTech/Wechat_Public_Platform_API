package com.xiaozhuan.weixinUtil.message.service;


public class PostArticleMessage extends BaseMessage {
	//发送的图文对象
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
