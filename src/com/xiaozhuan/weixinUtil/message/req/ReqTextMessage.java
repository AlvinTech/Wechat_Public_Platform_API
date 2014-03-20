package com.xiaozhuan.weixinUtil.message.req;

import com.xiaozhuan.weixinUtil.message.Message;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class ReqTextMessage extends Message {
	private String Content;// 文本消息内容
	private String MsgId;// 消息id，64位整型

	public String getContent() {
		return Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String MsgId) {
		this.MsgId = MsgId;
	}
}
