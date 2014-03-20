package com.xiaozhuan.weixinUtil.message.service;

public class BaseMessage {
	// 接收方帐号（收到的OpenID）
	private String touser;
	// 消息类型
	private String msgtype;
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
