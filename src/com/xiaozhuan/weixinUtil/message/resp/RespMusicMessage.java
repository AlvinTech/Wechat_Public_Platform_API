package com.xiaozhuan.weixinUtil.message.resp;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.message.MessageType;

public class RespMusicMessage extends Message {
	private Music Music;

	public RespMusicMessage() {
		MsgType = MessageType.MUSIC;
	}

	public RespMusicMessage(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MessageType.MUSIC);
		MsgType = MessageType.MUSIC;
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
