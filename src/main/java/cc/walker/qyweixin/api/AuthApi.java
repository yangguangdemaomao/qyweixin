package cc.walker.qyweixin.api;

import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.cnst.QyWechatConfig;
import cc.walker.qyweixin.token.AccessToken;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * OAuth2.0验证接口说明
 * 企业应用中的URL链接（包括自定义菜单或者消息中的链接），可以通过OAuth2.0验证接口来获取成员的身份信息。
 * 通过此接口获取成员身份会有一定的时间开销。对于频繁获取成员身份的场景，建议采用如下方案：
 * 1、企业应用中的URL链接直接填写企业自己的页面地址
 * 2、成员跳转到企业页面时，企业校验是否有代表成员身份的cookie，此cookie由企业生成
 * 3、如果没有获取到cookie，重定向到OAuth验证链接，获取成员身份后，由企业生成代表成员身份的cookie
 * 4、根据cookie获取成员身份，进入相应的页面
 * 注意，此URL的域名，必须完全匹配企业应用设置项中的'可信域名'（如果你的redirect_uri有端口号，那'可信域名'也必须加上端口号），否则跳转时会提示redirect_uri参数错误。
 *
 * @author walker
 * @date 2016-09-07
 */
public class AuthApi {

	private static final String API_GETUSERINFO = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	private static final String API_CONVERT_TO_OPENID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=";
	private static final String API_CONVERT_TO_USERID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid?access_token=";
	
	/**
	 * 根据code获取成员信息
	 * @param code
	 * @return
	 */
	public static ApiResult getUserInfo(String code) {
		ApiResult result = null;
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_GETUSERINFO.replace("ACCESS_TOKEN", token).replace("CODE", code), "GET", null);
		if (StrUtil.notBlank(json)) {
			result = new ApiResult(json);
		}
		return result;
	}
	
	/**
	 * 根据code获取成员信息
	 * @param code
	 * @param retryOnException
	 * @return
	 */
	public static ApiResult getUserInfo(String code, int retryOnException) {
		ApiResult result = null;
		for (int i=0; i<retryOnException; i++) {
			result = getUserInfo(code);
			if (result != null) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * userid转换成openid接口
	 * 
	 * @param userid
	 * @return ApiResult 
	 */
	public static ApiResult convertUserId2OpenId(String userid) {
		StringBuilder postStr = new StringBuilder("{\"userid\":\"");
		postStr.append(userid).append("\",\"agentid\":").append(QyWechatConfig.getAppid());
		String json = HttpUtil.httpsRequest(API_CONVERT_TO_OPENID + TokenManager.getToken(), "POST", postStr.toString());
		if (json != null) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * openid转换成userid接口
	 * 
	 * @param openid
	 * @return AuthUserId 
	 */
	public static ApiResult convertOpenId2UserId(String openid) {
		StringBuilder postStr = new StringBuilder("{\"openid\":\"");
		postStr.append(openid).append("\"");
		String json = HttpUtil.httpsRequest(API_CONVERT_TO_USERID + TokenManager.getToken(), "POST", postStr.toString());
		if (json != null) {
			return new ApiResult(json);
		}
		return null;
	}
	
	public static void main(String[] args) {
		AccessToken at = new AccessToken();
		at.setAccess_token("4XJcQz0epdvkD97PHcB_epr6IjS91aMchVDB-a4F5dLMhGo9v-YGUfkCjroRsaJm");
		TokenManager.setAt(at);
		ApiResult apiResult = getUserInfo("654e4c06cd2081b1018c974ff9bb1e4d");
		System.out.println(apiResult.getInt("errcode"));
	}
}
