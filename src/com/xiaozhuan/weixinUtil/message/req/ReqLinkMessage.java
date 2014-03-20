package com.xiaozhuan.weixinUtil.message.req;

import com.xiaozhuan.weixinUtil.message.Message;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class ReqLinkMessage extends Message {
	private String Title;// 消息标题
	private String Description;// 消息描述
	private String Url;// 消息链接
	private String MsgId;// 消息id，64位整型

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String MsgId) {
		this.MsgId = MsgId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
