package com.xiaozhuan.weixinUtil.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.communication.Poster;
import com.xiaozhuan.weixinUtil.message.req.ReqImageMessage;
import com.xiaozhuan.weixinUtil.message.resp.RespTextMessage;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class ImageController {

	@RequestMapping(value = "/image.do", method = RequestMethod.POST)
	protected void image(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String xmlText = (String) request.getAttribute("xmlText");
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");
		XmlUtil xmlUtil = XmlUtil.getInstance();

		ReqImageMessage pm = (ReqImageMessage) xmlUtil.xml2bean(
				xmlText, ReqImageMessage.class);
		String rs = "图片消息已收到" + "\n" + "MediaId是：";
		rs += pm.getMsgId();

		RespTextMessage message = new RespTextMessage(openId, from, rs);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));
	}
	
}
