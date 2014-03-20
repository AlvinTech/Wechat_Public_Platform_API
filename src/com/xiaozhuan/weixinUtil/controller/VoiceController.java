package com.xiaozhuan.weixinUtil.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.communication.Poster;
import com.xiaozhuan.weixinUtil.message.req.ReqVoiceMessage;
import com.xiaozhuan.weixinUtil.message.resp.RespTextMessage;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class VoiceController {

	@RequestMapping(value = "/voice.do", method = RequestMethod.POST)
	protected void voice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String xmlText = (String) request.getAttribute("xmlText");
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");
		XmlUtil xmlUtil = XmlUtil.getInstance();

		ReqVoiceMessage rvm = (ReqVoiceMessage) xmlUtil.xml2bean(xmlText,
				ReqVoiceMessage.class);
		String rs = "语音消息已收到" + "\n" + "MediaId是：";
		rs += rvm.getMediaId();

		RespTextMessage message = new RespTextMessage(openId, from, rs);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));
	}
	
}
