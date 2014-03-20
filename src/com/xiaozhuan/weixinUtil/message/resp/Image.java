package com.xiaozhuan.weixinUtil.message.resp;

public class Image {
	private String MediaId;// 通过上传多媒体文件，得到的id

	public Image() {
	}

	public Image(String MediaId) {
		this.MediaId = MediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
