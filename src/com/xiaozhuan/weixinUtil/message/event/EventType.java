package com.xiaozhuan.weixinUtil.message.event;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
/* 事件类型 */
public class EventType {
	/* 关注事件 */
	public static final String SUBSCRIBE = "subscribe";
	/* 取消关注事件 */
	public static final String UNSUBSCRIBE = "unsubscribe";
	/* 自定义菜单事件 */
	public static final String CLICK = "CLICK";
	/* 上报地理位置事件 */
	public static final String LOCATION = "LOCATION";
	/* 扫描带参数二维码事件 */
	public static final String SCAN = "SCAN";
}
