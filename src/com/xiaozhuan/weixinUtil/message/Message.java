package com.xiaozhuan.weixinUtil.message;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public abstract class Message {
	public String ToUserName;
	public String FromUserName;
	public long CreateTime;
	public String MsgType;

	public Message() {
	}

	public Message(String ToUserName, String FromUserName, String MsgType) {
		this.ToUserName = ToUserName;
		this.FromUserName = FromUserName;
		this.MsgType = MsgType;
		this.CreateTime = System.currentTimeMillis() / 1000L;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String ToUserName) {
		this.ToUserName = ToUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String FromUserName) {
		this.FromUserName = FromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long CreateTime) {
		this.CreateTime = CreateTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String MsgType) {
		this.MsgType = MsgType;
	}

}
