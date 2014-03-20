/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
package com.xiaozhuan.weixinUtil.message.entity;

public class QRCode {
	private int expire_seconds;// 该二维码有效时间，以秒为单位。 最大不超过1800
	private String action_name;// 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
	private ActionInfo action_info;// 二维码详细信息

	public int getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public ActionInfo getAction_info() {
		return action_info;
	}

	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}

}
