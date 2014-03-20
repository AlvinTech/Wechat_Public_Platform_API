package com.xiaozhuan.weixinUtil.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhuan.weixinUtil.message.event.EventType;
import com.xiaozhuan.weixinUtil.utils.ReadProperties;
import com.xiaozhuan.weixinUtil.utils.SignUtil;
import com.xiaozhuan.weixinUtil.utils.XmlUtil;

@Controller
public class CoreController {

	@RequestMapping("/core.do")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		String token = ReadProperties.loadProperties().getProperty("TOKEN");

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(token, signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	@RequestMapping(value = "/core.do", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		XmlUtil xmlUtil = XmlUtil.getInstance();
		xmlUtil.setRequest(request);

		String servletToGo = "";
		String directive = "";

		if ("text".equals(xmlUtil.getContentByNodeName("MsgType"))) {
			//文本消失
			servletToGo = "/text.do";
		} else if ("image".equals(xmlUtil.getContentByNodeName("MsgType"))) {
			//图片消息
			servletToGo = "/image.do";
		} else if ("voice".equals(xmlUtil.getContentByNodeName("MsgType"))) {
			// 语音消息
			servletToGo = "/voice.do";
		} else if ("location".equals(xmlUtil.getContentByNodeName("MsgType"))) {
			// 地理位置消息
			servletToGo = "/location1.do";
		} else if ("event".equals(xmlUtil.getContentByNodeName("MsgType"))) {
			// 事件消息
			directive = xmlUtil.getContentByNodeName("Event");
			if (EventType.SUBSCRIBE.equals(directive)) {
				// 关注事件
				servletToGo = "/welcome.do";
			} else if (EventType.UNSUBSCRIBE.equals(directive)) {
				// 取消关注事件
			} else if (EventType.CLICK.equals(directive)) {
				// 自定义菜单事件
				servletToGo = "/click.do";
			} else if (EventType.LOCATION.equals(directive)) {
				// 上报地理位置消息事件
				servletToGo = "/location2.do";
			}
		} else {
			
		}

		request.setAttribute("xmlText", xmlUtil.getDocumentStr());
		request.setAttribute("type", xmlUtil.getContentByNodeName("MsgType"));
		request.setAttribute("openId", xmlUtil.getContentByNodeName("FromUserName"));
		request.setAttribute("from", xmlUtil.getContentByNodeName("ToUserName"));

		try {
			request.getRequestDispatcher(servletToGo).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
