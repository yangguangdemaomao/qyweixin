
package cc.walker.qyweixin.token;

import org.apache.log4j.Logger;

import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 获取access_token的api接口
 * 
 * @author walker 
 * @date 2016-09-06
 */
public class AccessTokenApi {
	private static final Logger logger = Logger.getLogger(AccessTokenApi.class);

	private static final String API_GET_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=#corpid#&corpsecret=#corpsecret#";

	/**
	 * 获取accesstoken对象
	 * @param corpid
	 * @param corpsecret
	 * @return AccessToken对象
	 */
	public static AccessToken getAccessToken(String corpid, String corpsecret) {
		String json = HttpUtil.httpsRequest(API_GET_TOKEN.replace("#corpid#", corpid).replace("#corpsecret#", corpsecret), "GET", null);
		logger.info("调用获取access_token方法完成，返回内容：" + json);
		if (StrUtil.notBlank(json)) {
			AccessToken accessToken = JsonUtil.fromJson(json, AccessToken.class);
			if (accessToken.isValid()) {
				logger.info("access_token获取成功");
				return accessToken;
			}
		}
		logger.info("access_token获取失败");
		return null;
	}
	
	/**
	 *  获取accesstoken对象
	 * @param corpid
	 * @param corpsecret
	 * @param retryTimeOnException 调用失败情况下调用次数上限
	 * @return AccessToken对象
	 */
	public static AccessToken getAccessToken(String corpid, String corpsecret, int retryTimeOnException) {
		AccessToken accessToken = null;
		for (int i=0; i<retryTimeOnException; i++) {
			String json = HttpUtil.httpsRequest(API_GET_TOKEN.replace("#corpid#", corpid).replace("#corpsecret#", corpsecret), "GET", null);
			logger.info("第"+(i+1)+"次调用获取access_token方法完成，返回内容：" + json);
			if (StrUtil.notBlank(json)) {
				accessToken = JsonUtil.fromJson(json, AccessToken.class);
				if (accessToken.isValid()) {
					logger.info("access_token获取成功");
					return accessToken;
				}
			}
		}
		logger.info("access_token获取失败");
		return null;
	}
}
