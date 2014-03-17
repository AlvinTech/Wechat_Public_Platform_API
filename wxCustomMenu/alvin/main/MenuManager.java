package alvin.main;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import alvin.pojo.AccessToken;
import alvin.pojo.Button;
import alvin.pojo.CommonButton;
import alvin.pojo.ComplexButton;
import alvin.pojo.Menu;
import alvin.pojo.ViewButton;
import alvin.util.ReadProperties;
import alvin.util.WeixinUtil;

/**
 * 菜单管理器类
 * 
 * @author ALvin
 * @date 2013年12月27日 下午1:51:21
 */
public class MenuManager {

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = ReadProperties.loadProperties().getProperty("APPID");
		// 第三方用户唯一凭证密钥
		String appSecret = ReadProperties.loadProperties().getProperty("APPSECRET");

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		System.out.println(at.getToken());
		if (null != at) {
			// 调用接口创建菜单
//			int result = WeixinUtil.createMenu(getMenu(), at.getToken());
			
//			// 调用接口创建分组
//			String outputStr = "{'group':{'name':'test'}}";
//			String result = WeixinUtil.createGroup(at.getToken(), outputStr);
//			System.out.println(result.split(":")[1].split(",")[0]);
			
			//调用接口生成二维码
			String outputStr = "{'expire_seconds': 1800,'action_name': 'QR_SCENE', 'action_info': {'scene': {'scene_id': 101}}}";
			String result = WeixinUtil.createQRCode(at.getToken(), outputStr);

//			//移动用户到指定分组
//			String outputStr = "{'openid':'" + openId + "','to_groupid':" + groupid + "}";
//			int result = WeixinUtil.changeUserGroup(at.getToken(),outputStr);
			
			// 判断菜单创建结果
			if ("" != result) {
				System.out.println(result);
				System.out.println("菜单创建成功！");
			} else {
				System.out.println("菜单创建失败，错误码：" + result);
			}
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {

		CommonButton btn11 = new CommonButton();
		btn11.setName("Bt_11");
		btn11.setType("click");
		btn11.setKey("value_11");

		CommonButton btn12 = new CommonButton();
		btn12.setName("Bt_12");
		btn12.setType("click");
		btn12.setKey("value_12");

		CommonButton btn13 = new CommonButton();
		btn13.setName("Bt_13");
		btn13.setType("click");
		btn13.setKey("value_13");

		ViewButton btn14 = new ViewButton();
		btn14.setName("Bt_14");
		btn14.setType("view");
		btn14.setUrl("http://www.baidu.com");

		CommonButton btn21 = new CommonButton();
		btn21.setName("Bt_21");
		btn21.setType("click");
		btn21.setKey("value_21");

		CommonButton btn22 = new CommonButton();
		btn22.setName("Bt_22");
		btn22.setType("click");
		btn22.setKey("value_22");

		CommonButton btn23 = new CommonButton();
		btn23.setName("Bt_23");
		btn23.setType("click");
		btn23.setKey("value_23");

		CommonButton btn24 = new CommonButton();
		btn24.setName("Bt_24");
		btn24.setType("click");
		btn24.setKey("value_24");

		CommonButton btn25 = new CommonButton();
		btn25.setName("Bt_25");
		btn25.setType("click");
		btn25.setKey("value_25");

		CommonButton btn31 = new CommonButton();
		btn31.setName("Bt_31");
		btn31.setType("click");
		btn31.setKey("value_31");

		ViewButton btn32 = new ViewButton();
		btn32.setName("Bt_32");
		btn32.setType("view");
		btn32.setUrl("http://www.google.com");

		ViewButton btn33 = new ViewButton();
		btn33.setName("Bt_33");
		btn33.setType("view");
		btn33.setUrl("");

		CommonButton btn34 = new CommonButton();
		btn34.setName("Bt_34");
		btn34.setType("click");
		btn34.setKey("value_34");

		CommonButton btn35 = new CommonButton();
		btn35.setName("Bt_35");
		btn35.setType("click");
		btn35.setKey("value_35");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("菜单1");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("菜单2");
		mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24,
				btn25 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("菜单3");
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34, btn35 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}