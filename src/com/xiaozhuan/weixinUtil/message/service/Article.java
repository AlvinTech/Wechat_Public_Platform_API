package com.xiaozhuan.weixinUtil.message.service;

/**
 * Created with IntelliJ IDEA.
 * User: ywl
 * Date: 2013-12-24
 * Time: 下午10:20
 * To change this template use File | Settings | File Templates.
 */
public class Article {
    private String title;//图文消息标题
    private String description;//图文消息描述
    private String picurl;//图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
    private String url;//点击图文消息跳转链接

    public Article(){}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
