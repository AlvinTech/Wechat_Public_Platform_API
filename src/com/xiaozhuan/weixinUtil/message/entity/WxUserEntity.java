package com.xiaozhuan.weixinUtil.message.entity;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
public class WxUserEntity {
	private Integer id;
	private String openId;//用户的唯一标识
	private String nickName;//用户昵称
	private String sex;//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String province;//用户个人资料填写的省份
	private String city;//普通用户个人资料填写的城市
	private String country;//国家，如中国为CN
	private String headimgurl;//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	private String privilege;//用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	private String subscribe;//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private String language;//用户的语言，简体中文为zh_CN
	private long subscribe_time;//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
}
