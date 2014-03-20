package com.xiaozhuan.weixinUtil.message.service;

/**
 * Created with IntelliJ IDEA.
 * User: ywl
 * Date: 2013-12-20
 * Time: 下午16:14
 * To change this template use File | Settings | File Templates.
 */
public class Video {
	//发送的视频的媒体ID
	private String media_id;
	//视频消息的标题
	private String title;
	//视频消息的描述
	private String description;

    public Video(){}

    public Video(String media_id,String title,String description) {
        this.media_id = media_id;
        this.title = title;
        this.description = description;
    }

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
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
}
