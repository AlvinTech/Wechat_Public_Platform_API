package com.xiaozhuan.weixinUtil.message.req;

import java.io.File;
import java.io.IOException;

import com.xiaozhuan.weixinUtil.message.Message;
import com.xiaozhuan.weixinUtil.utils.GetAmrDuration;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class ReqVoiceMessage extends Message {
	private String MsgId;// 消息id，64位整型
	private String MediaId;// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String Format;// 语音格式，如amr，speex等
	private String Recognition;// 语音识别结果，UTF8编码

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String MsgId) {
		this.MsgId = MsgId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public int downLoadVoice(String fileName, String voiceUrl) {
		LoadVoice down = new LoadVoice();
		down.setFile(fileName);
		down.setUrlVoice(voiceUrl);
		Thread thread = new Thread(down);
		thread.start();
		int voiceLen = 0;
		while (true) {
			if (!thread.isAlive()) {
				try {
					voiceLen = GetAmrDuration
							.getAmrDuration(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}

		}
		return voiceLen;
	}
}
