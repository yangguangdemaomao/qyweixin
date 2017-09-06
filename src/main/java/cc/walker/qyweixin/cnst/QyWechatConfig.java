package cc.walker.qyweixin.cnst;

import java.io.IOException;
import java.util.Properties;

public class QyWechatConfig {

	private static String tmpSavePath;
	private static String corpid;
	private static String corpsecret;
	private static String appid;
	private static String encodingAESKey;
	private static String token;
	private static String corpid2;
	private static String corpsecret2;

	static {
		synchronized (QyWechatConfig.class) {
			// 初始化对应的参数，从配置文件中读取
			Properties properties = new Properties();
			try {
				properties.load(QyWechatConfig.class.getClassLoader().getResourceAsStream("qywechat.properties"));
				corpid = properties.getProperty("corpid");
				corpsecret = properties.getProperty("corpsecret");
				corpid2 = properties.getProperty("corpid2");
				corpsecret2 = properties.getProperty("corpsecret2");
				appid = properties.getProperty("appid");
				tmpSavePath = properties.getProperty("tmpSavePath");
				encodingAESKey = properties.getProperty("encodingAESKey");
				token = properties.getProperty("token");
			} catch (IOException e) {
				throw new RuntimeException("参数初始化失败,请检查您的配置路径及配置文件是否存在问题。");
			}
		}
	}

	public static String getTmpSavePath() {
		return tmpSavePath;
	}

	public static String getCorpid() {
		return corpid;
	}

	public static String getCorpsecret() {
		return corpsecret;
	}

	public static String getAppid() {
		return appid;
	}

	public static String getEncodingAESKey() {
		return encodingAESKey;
	}

	public static String getToken() {
		return token;
	}

	public static String getCorpid2() {
		return corpid2;
	}

	public static String getCorpsecret2() {
		return corpsecret2;
	}
}
