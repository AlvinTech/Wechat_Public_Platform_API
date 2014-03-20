package com.xiaozhuan.weixinUtil.message.req;

import com.xiaozhuan.weixinUtil.message.Message;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class ReqVideoMessage extends Message {
	private String MsgId;// 消息id，64位整型
	private String MediaId;// 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String ThumbMediaId;// 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
