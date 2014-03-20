package com.xiaozhuan.weixinUtil.message.resp;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.message.MessageType;

public class RespVoiceMessage extends Message {
	private Voice Voice;

	public RespVoiceMessage() {
		MsgType = MessageType.VOICE;
	}

	public RespVoiceMessage(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MessageType.VOICE);
		MsgType = MessageType.VOICE;
	}

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
