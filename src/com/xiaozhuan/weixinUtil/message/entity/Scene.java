package com.xiaozhuan.weixinUtil.message.entity;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class Scene {
	private int scene_id;// 场景值ID，临时二维码时为32位整型，永久二维码时最大值为1000

	public int getScene_id() {
		return scene_id;
	}

	public void setScene_id(int scene_id) {
		this.scene_id = scene_id;
	}
}
