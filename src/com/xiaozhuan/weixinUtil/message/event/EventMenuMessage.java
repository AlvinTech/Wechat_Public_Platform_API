package com.xiaozhuan.weixinUtil.message.event;

import com.xiaozhuan.weixinUtil.message.Message;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class EventMenuMessage extends Message {
	private String Event;
	private String EventKey;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
