package com.xiaozhuan.weixinUtil.message.resp;

public class Voice {
	private String MediaId;// 通过上传多媒体文件，得到的id

	public Voice() {
	}

	public Voice(String MediaId) {
		this.MediaId = MediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
