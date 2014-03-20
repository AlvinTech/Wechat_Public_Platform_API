package com.xiaozhuan.weixinUtil.message.service;

/**
 * Created with IntelliJ IDEA.
 * User: ywl
 * Date: 2013-12-20
 * Time: 下午16:14
 * To change this template use File | Settings | File Templates.
 */
public class Music {
	//音乐链接
	private String musicurl;
	//音乐标题
	private String title;
	//音乐描述
	private String description;
	//高品质音乐链接，wifi环境优先使用该链接播放音乐
	private String hqmusicurl;
	//缩略图的媒体ID
	private String thumb_media_id;

    public Music(){}

    public Music(String musicurl,String title,String description,String hqmusicurl,String thumb_media_id) {
        this.musicurl = musicurl;
        this.title = title;
        this.description = description;
        this.hqmusicurl = hqmusicurl;
        this.thumb_media_id = thumb_media_id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMusicurl() {
		return musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	public String getHqmusicurl() {
		return hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
}
