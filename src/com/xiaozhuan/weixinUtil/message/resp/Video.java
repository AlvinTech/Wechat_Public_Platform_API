package com.xiaozhuan.weixinUtil.message.resp;

public class Video {
	private String MediaId;// 通过上传多媒体文件，得到的id
	private String Title;// 视频消息的标题
	private String Description;// 视频消息的描述

	public Video() {
	}

	public Video(String MediaId, String Title, String Description) {
		this.MediaId = MediaId;
		this.Title = Title;
		this.Description = Description;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
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
}
