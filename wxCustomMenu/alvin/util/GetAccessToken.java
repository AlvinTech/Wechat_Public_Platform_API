package alvin.util;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetAccessToken {

	final static int BUFFER_SIZE = 4096;

	public static String getTokenFromUrl(String url) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		HttpResponse response;
		try {
			response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			String json = InputStreamTOString(entity.getContent());
			JSONObject jsonobject = JSONObject.fromObject(json);
			return (String) jsonobject.get("token");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String InputStreamTOString(InputStream in) throws Exception {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		return new String(outStream.toByteArray(), "ISO-8859-1");
	}

	public static void main(String[] args) {
		String url = "http://www.znjtcc.com/newdyjj/getAccessToken.do";
		System.out.println(getTokenFromUrl(url));
	}

}
