package com.xiaozhuan.weixinUtil.message.req;

import com.xiaozhuan.weixinUtil.message.Message;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class ReqImageMessage extends Message {
	private String PicUrl;// 图片链接
	private String MediaId;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String MsgId;// 消息id，64位整型

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public void downLoadImage(String fileName) {
		LoadImage down = new LoadImage();
		down.setFile(fileName);
		down.setUrlImage(PicUrl);
		System.out.println(PicUrl);

		new Thread(down).start();

	}

}
