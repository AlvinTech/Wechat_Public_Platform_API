package com.xiaozhuan.weixinUtil.message.service;

/**
 * Created with IntelliJ IDEA.
 * User: ywl
 * Date: 2013-12-20
 * Time: 下午16:14
 * To change this template use File | Settings | File Templates.
 */
public class Voice {
	//发送的语音的媒体ID
	private String media_id;

    public Voice(){}

    public Voice(String media_id) {
        this.media_id = media_id;
    }

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
}
