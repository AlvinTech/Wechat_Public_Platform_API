package com.xiaozhuan.weixinUtil.message.resp;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.message.MessageType;

public class RespTextMessage extends Message {
	private String Content;

	public RespTextMessage() {
		MsgType = MessageType.TEXT;
	}

	public RespTextMessage(String toUserName, String fromUserName,
			String content) {
		super(toUserName, fromUserName, MessageType.TEXT);
		this.Content = content;
		MsgType = MessageType.TEXT;

	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}
}
