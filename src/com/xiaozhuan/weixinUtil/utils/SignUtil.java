package com.xiaozhuan.weixinUtil.utils;

/**
 * Created with IntelliJ IDEA.
 * User: weiyiming
 * Date: 13-7-16
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SignUtil {
    // 与接口配置信息中的Token要一致

    /**
     * 验证签名
     *
     * @param token
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
        String[] arr = new String[] { token, timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
    
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
		if(str != null && !"".equals(str)) {
			return false;
		}else {
			return true;
		}
	}
	
    /**
     * 判断字符串不为空
     * @param str
     * @return
     */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	/**
	 * 获取标准格式的时间
	 */
	
	public static String time2str(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public static Date str2Date(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String txt2jsp(String str) {
		String in = str;
		String content="";
		   StringBuffer ou = new StringBuffer();   
		     for(int i = 0; in != null && i < in.length(); i++)   
		     {   
		             char   c   =   in.charAt(i);   
		             if   (c   ==   '\'')   
		            	 ou.append("&#039;");   
		             else   if   (c == '\"')   
		            	 ou.append("&#034;");   
		             else   if   (c == '<')   
		            	 ou.append("&lt;");   
		             else   if   (c == '>') 
		            	 ou.append("&gt;");   
		             else   if   (c == '&')   
		            	 ou.append("&amp;");   
		             else   if   (c == ' ')   
		            	 ou.append("&nbsp;");   
		             else   if   (c   ==   '\n')   
		            	 ou.append("<br>");   
		             else   
		            	 ou.append(c);   
		     }   
		 content = ou.toString();
		 return content;
	}
	
	//手机号的验证
	public static boolean isMobileNO(String mobiles){

		Pattern p = Pattern.compile("^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$");

		Matcher m = p.matcher(mobiles);

		return m.matches();
	}
	
	@SuppressWarnings("static-access")
	public static boolean workTime(){
		Date date = new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(date); 
		if(cal.get(cal.DAY_OF_WEEK)>1 && cal.get(cal.DAY_OF_WEEK) <7 && cal.get(cal.HOUR_OF_DAY)>6 && cal.get(cal.HOUR_OF_DAY)<17 ){
			return true;
		}
		else{
			return false;
		}
	}
}

