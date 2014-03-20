package com.xiaozhuan.weixinUtil.message.resp;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.message.MessageType;

public class RespVideoMessage extends Message {
	private Video Video;

	public RespVideoMessage() {
		MsgType = MessageType.VIDEO;
	}

	public RespVideoMessage(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MessageType.VIDEO);
		MsgType = MessageType.VIDEO;
	}

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}
