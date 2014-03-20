package com.xiaozhuan.weixinUtil.message.resp;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.message.MessageType;

public class RespImageMessage extends Message {
	private Image Image;

	public RespImageMessage() {
		MsgType = MessageType.IMAGE;
	}

	public RespImageMessage(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MessageType.IMAGE);
		MsgType = MessageType.IMAGE;

	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

}
