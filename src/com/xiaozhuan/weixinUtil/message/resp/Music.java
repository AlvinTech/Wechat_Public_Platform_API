package com.xiaozhuan.weixinUtil.message.resp;

public class Music {
	private String Title;// 音乐标题
	private String Description;// 音乐描述
	private String MusicUrl;// 音乐链接
	private String HQMusicUrl;// 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String ThumbMediaId;// 缩略图的媒体id，通过上传多媒体文件，得到的id

	public Music() {
	}

	public Music(String Title, String Description, String MusicUrl,
			String HQMusicUrl, String ThumbMediaId) {
		this.Title = Title;
		this.Description = Description;
		this.MusicUrl = MusicUrl;
		this.HQMusicUrl = HQMusicUrl;
		this.ThumbMediaId = ThumbMediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String MusicUrl) {
		this.MusicUrl = MusicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String HQMusicUrl) {
		this.HQMusicUrl = HQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
