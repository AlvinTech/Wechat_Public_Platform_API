package com.xiaozhuan.weixinUtil.message.resp;

public class Article {
	private String Title;// 图文消息标题
	private String Description;// 图文消息描述
	private String PicUrl;// 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	private String Url;// 点击图文消息跳转链接

	public Article() {
	}

	public Article(String Title, String Description, String PicUrl, String Url) {
		this.Title = Title;
		this.Description = Description;
		this.PicUrl = PicUrl;
		this.Url = Url;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String PicUrl) {
		this.PicUrl = PicUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String Url) {
		this.Url = Url;
	}
}
