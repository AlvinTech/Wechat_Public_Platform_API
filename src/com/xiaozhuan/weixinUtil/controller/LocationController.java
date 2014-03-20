package com.xiaozhuan.weixinUtil.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.communication.Poster;
import com.xiaozhuan.weixinUtil.message.event.EventLocationMessage;
import com.xiaozhuan.weixinUtil.message.req.ReqLocationMessage;
import com.xiaozhuan.weixinUtil.message.resp.RespTextMessage;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class LocationController {

	@RequestMapping(value = "/location1.do", method = RequestMethod.POST)
	public void location1(HttpServletRequest request, HttpServletResponse response) {
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");
		String xmlText = (String) request.getAttribute("xmlText");
		XmlUtil xmlUtil = XmlUtil.getInstance();
		
		ReqLocationMessage elm = (ReqLocationMessage) xmlUtil.xml2bean(
				xmlText, ReqLocationMessage.class);
		String rs = "位置信息已收到" + "\n";
		rs += "经度：" + elm.getLocation_X() + "\n";
		rs += "纬度：" + elm.getLocation_Y() + "\n";
		
		RespTextMessage message = new RespTextMessage(openId, from, rs);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));
	}
	
	@RequestMapping(value = "/location2.do", method = RequestMethod.POST)
	public void location2(HttpServletRequest request, HttpServletResponse response) {
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");
		String xmlText = (String) request.getAttribute("xmlText");
		XmlUtil xmlUtil = XmlUtil.getInstance();
		
		EventLocationMessage elm = (EventLocationMessage) xmlUtil.xml2bean(
				xmlText, EventLocationMessage.class);
		String rs = "位置信息已收到" + "\n";
		rs += "经度：" + elm.getLatitude() + "\n";
		rs += "纬度：" + elm.getLongitude() + "\n";

		RespTextMessage message = new RespTextMessage(openId, from, rs);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));
	}
}
