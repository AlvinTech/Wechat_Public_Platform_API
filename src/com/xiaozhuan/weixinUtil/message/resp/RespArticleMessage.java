package com.xiaozhuan.weixinUtil.message.resp;

import java.util.List;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.message.MessageType;

public class RespArticleMessage extends Message {
	private int ArticleCount;
	private List<Article> Articles;

	public RespArticleMessage() {
		MsgType = MessageType.NEWS;
	}

	public RespArticleMessage(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MessageType.NEWS);
		MsgType = MessageType.NEWS;
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
		ArticleCount = articles.size();
	}
}
