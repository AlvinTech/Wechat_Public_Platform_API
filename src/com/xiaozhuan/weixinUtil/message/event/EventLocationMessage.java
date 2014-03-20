package com.xiaozhuan.weixinUtil.message.event;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
import com.xiaozhuan.weixinUtil.message.Message;

public class EventLocationMessage extends Message {
	private String Event;// 事件类型，LOCATION
	private String Latitude;// 地理位置纬度
	private String Longitude;// 地理位置经度
	private String Precision;// 地理位置精度

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}
}
