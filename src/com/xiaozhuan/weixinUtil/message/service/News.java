package com.xiaozhuan.weixinUtil.message.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ywl
 * Date: 2013-12-24
 * Time: 下午10:20
 * To change this template use File | Settings | File Templates.
 */
public class News {
	//发送的图文对象
	private List<Article> articles;

    public News(){}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
