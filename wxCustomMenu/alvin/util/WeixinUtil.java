package alvin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import alvin.pojo.AccessToken;
import alvin.pojo.Menu;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 公众平台通用接口工具类
 *
 * @author Alvin
 * @date 2013年12月27日 下午1:54:02
 */
public class WeixinUtil {

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			System.out.println("Weixin server connection timed out.");
			ce.printStackTrace();
		} catch (Exception e) {
			System.out.println("https request error:{}");
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return access_token
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				System.out.println("获取token失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	
	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		// 如果请求成功
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				System.out.println("创建菜单失败 errcode:{} errmsg:{}"+
						jsonObject.getInt("errcode")+
						jsonObject.getString("errmsg"));
			}
		}

		return result;
	}
	
	//获取用户基本信息
	public static String get_userInfo_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	
	//移动用户到指定分组
	public static String change_user_group = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	
	/**
	 * 移动用户到指定分组
	 * 
	 * @param accessToken 有效的access_token
	 * @param outputStr 提交的数据
	 * @return 0表示成功，其他值表示失败
	 */
	public static int changeUserGroup(String accessToken,String outputStr) {
		int result = 0;
		
		// 拼装创建菜单的url
		String url = change_user_group.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(outputStr).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		// 如果请求成功
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				System.out.println("移动分组失败 errcode:{} errmsg:{}"+
						jsonObject.getInt("errcode")+
						jsonObject.getString("errmsg"));
			}
		}
		
		return result;
	}
	
	// 生成带参数的二维码
	// 1、创建二维码ticket:临时二维码、永久二维码
	public static String create_ticket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	// 2、通过ticket换取二维码
	public static String get_QRCode = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	/**
	 * 生成带参数的二维码的URL
	 * 
	 * @param accessToken 有效的access_token
	 * @param outputStr 提交的数据
	 * @return
	 */
	public static String createQRCode(String accessToken,String outputStr) {
		String ticket = null;
		
		// 拼装创建菜单的url
		String url = create_ticket_url.replace("TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(outputStr).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				ticket = jsonObject.getString("ticket");
			} catch (JSONException e) {
				ticket = null;
				// 获取ticket失败
				System.out.println("获取ticket失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
			}
		}
		
		return get_QRCode.replace("TICKET", ticket);
	}
	
	//创建分组
	private static String create_group = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=TOKEN";
	
	/**
	 * 创建分组
	 * @param accessToken 有效的access_token
	 * @param outputStr 提交的数据
	 * @return
	 */
	public static String createGroup(String accessToken,String outputStr) {
		String result = null;
		
		// 拼装创建分组的url
		String url = create_group.replace("TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(outputStr).toString();
		// 调用接口创建分组
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				result = jsonObject.getString("group");
			} catch (JSONException e) {
				System.out.println("创建分组失败 errcode:{} errmsg:{}"+
						jsonObject.getInt("errcode")+
						jsonObject.getString("errmsg"));
			}
		}
		
		return result;
	}
}