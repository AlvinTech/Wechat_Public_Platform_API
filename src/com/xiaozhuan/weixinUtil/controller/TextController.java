package com.xiaozhuan.weixinUtil.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.communication.Poster;
import com.xiaozhuan.weixinUtil.message.req.ReqTextMessage;
import com.xiaozhuan.weixinUtil.message.resp.RespTextMessage;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class TextController {

	@RequestMapping(value = "/text.do", method = RequestMethod.POST)
	public void text(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xmlText = (String) request.getAttribute("xmlText");
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");
		XmlUtil xmlUtil = XmlUtil.getInstance();
		
		ReqTextMessage rtm = (ReqTextMessage) xmlUtil.xml2bean(xmlText,
				ReqTextMessage.class);
		String reciecedText = rtm.getContent();
		String rs = "文本消息已收到" + "\n" + "文本内容是：";
		rs += reciecedText;

		RespTextMessage message = new RespTextMessage(openId, from, rs);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));
	}
}
