package com.xiaozhuan.weixinUtil.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.xiaozhuan.weixinUtil.message.Message;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class XmlUtil {
	private static XmlUtil xmlUtil = new XmlUtil();
	private static SAXReader saxReader;
	private static Document document;
	private static XStream xStream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (!text.matches("^[0-9]+$")) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	private XmlUtil() {
	}

	public static XmlUtil getInstance() {
		return xmlUtil;
	}

	@SuppressWarnings("static-access")
	public void setURL(String url) {
		this.saxReader = new SAXReader();
		try {
			this.document = this.saxReader.read(new URL(url));
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void setRequest(HttpServletRequest request) {
		this.saxReader = new SAXReader();
		try {
			this.document = this.saxReader.read(request.getInputStream());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public boolean isEvent() {
		return (this.document.selectSingleNode("//MsgType").equals("event"));

	}

	public String getContentByNodeName(String nodeName) {
		@SuppressWarnings("static-access")
		Element element = (Element) this.document.selectSingleNode("//"
				+ nodeName);
		return element.getText();
	}

	public Map<String, String> parseXml(InputStream in) {
		Map<String, String> msg = new HashMap<String, String>();
		return msg;
	}

	@SuppressWarnings("rawtypes")
	public Object xml2bean(String xml, Class beanClass) {
		XStream xstream = new XStream(new StaxDriver());

		xstream.alias("xml", beanClass);
		return xstream.fromXML(xml);
	}

	@SuppressWarnings("static-access")
	public String bean2xml(Message msg, String str, Object obj) {
		this.xStream.alias("xml", msg.getClass());
		if (obj != null && SignUtil.isNotEmpty(str)) {
			this.xStream.alias(str, Object.class);
		}
		return this.xStream.toXML(msg);
	}

	@SuppressWarnings("static-access")
	public String getDocumentStr() {
		return this.document.asXML();

	}

	public static void zip(List<String> filename, String zipName) {
		try {
			FileOutputStream f = new FileOutputStream(zipName);
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
					f));
			for (int i = 0; i < filename.size(); i++) {
				@SuppressWarnings("resource")
				BufferedInputStream in = new BufferedInputStream(
						new FileInputStream(filename.get(i)));
				out.putNextEntry(new ZipEntry(i + ".jpg"));

				int len = 0;
				byte data[] = new byte[1024];
				while ((len = in.read(data)) != -1) {
					out.write(data, 0, len);
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
