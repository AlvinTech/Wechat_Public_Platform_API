package com.xiaozhuan.weixinUtil.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.communication.Poster;
import com.xiaozhuan.weixinUtil.message.resp.RespTextMessage;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class WelcomeController {

	private final static String WELCOME = "感谢关注本微信公众平台!\n";

	@RequestMapping(value = "/welcome.do", method = RequestMethod.POST)
	public void welcome(HttpServletRequest request, HttpServletResponse response) {
		// 从请求中取出openID
		String openId = (String) request.getAttribute("openId");
		String from = (String) request.getAttribute("from");

		RespTextMessage message = new RespTextMessage(openId, from, WELCOME);
		Poster.post(response, XmlUtil.getInstance().bean2xml(message, null, null));

	}

}
