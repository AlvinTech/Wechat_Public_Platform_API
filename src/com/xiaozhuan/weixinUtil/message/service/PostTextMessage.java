package com.xiaozhuan.weixinUtil.message.service;

public class PostTextMessage extends BaseMessage {
	//文本对象
	private Text text;

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
}
