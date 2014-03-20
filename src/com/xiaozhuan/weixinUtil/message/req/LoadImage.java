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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class LoadImage implements Runnable {

	private String urlImage;
	private String file;

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
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
			url = new URL(urlImage);
			File outFile = new File(file);
			// if(outFile.getParentFile().mkdirs())
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

	public void downLoadImage(String fileName, String picUrl) {
		LoadImage down = new LoadImage();
		down.setFile(fileName);
		down.setUrlImage(picUrl);
		System.out.println(fileName);

		new Thread(down).start();

	}

}
