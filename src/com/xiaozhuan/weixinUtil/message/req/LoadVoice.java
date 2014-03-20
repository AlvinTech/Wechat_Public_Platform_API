package com.xiaozhuan.weixinUtil.message.req;
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 13-12-24
 * Time: 下午13:30
 * To change this template use File | Settings | File Templates.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.xiaozhuan.weixinUtil.utils.GetAmrDuration;

public class LoadVoice implements Runnable {

	private String urlVoice;
	private String file;

	public String getUrlVoice() {
		return urlVoice;
	}

	public void setUrlVoice(String urlVoice) {
		this.urlVoice = urlVoice;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void run() {
		URL url;
		try {
			url = new URL(urlVoice);
			File outFile = new File(file);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			OutputStream os = new FileOutputStream(outFile);
			InputStream is = url.openStream();
			byte[] buff = new byte[1024];
			while (true) {
				int readed = is.read(buff);
				if (readed == -1) {
					break;
				}
				byte[] temp = new byte[readed];
				System.arraycopy(buff, 0, temp, 0, readed);
				os.write(temp);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int downLoadVoice(String fileName, String voiceUrl) {
		LoadVoice down = new LoadVoice();
		down.setFile(fileName);
		down.setUrlVoice(voiceUrl);
		Thread thread = new Thread(down);
		thread.start();
		int voiceLen = 0;
		while (true) {
			if (!thread.isAlive()) {
				try {
					voiceLen = GetAmrDuration
							.getAmrDuration(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}

		}
		return voiceLen;
	}

}
