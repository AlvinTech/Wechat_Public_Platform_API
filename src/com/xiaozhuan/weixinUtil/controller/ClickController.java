package com.xiaozhuan.weixinUtil.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.communication.Poster;
import com.xiaozhuan.weixinUtil.message.event.EventMenuMessage;
import com.xiaozhuan.weixinUtil.message.resp.RespTextMessage;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class ClickController {

	@RequestMapping(value = "/click.do", method = RequestMethod.POST)
	public void click(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xmlText = (String) request.getAttribute("xmlText");
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");
		XmlUtil xmlUtil = XmlUtil.getInstance();
		
		EventMenuMessage rtm = (EventMenuMessage) xmlUtil.xml2bean(xmlText, EventMenuMessage.class);
		String eventKey = rtm.getEventKey();
		String rs = "自定义菜单事件已响应" + "\n" + "value值是：";
		rs += eventKey;

		RespTextMessage message = new RespTextMessage(openId, from, rs);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));
	}
}
