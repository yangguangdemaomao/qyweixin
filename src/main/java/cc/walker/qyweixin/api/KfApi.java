package cc.walker.qyweixin.api;

import cc.walker.qyweixin.api.req.KfSendParam;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.api.result.KfListResult;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 向企业号客服发送客服消息
 * 该接口用于向客服人员发送消息，支持文本、图片、文件消息。sender和receiver有且只有一个类型为kf。
 * 当receiver为kf时，表示向客服发送用户咨询的问题消息。当sender为kf时，表示客服从其它IM工具回复客户，
 * 并同步消息到客服的微信上
 * 
 * @author walker
 *
 */
public class KfApi {

	private static final String API_KF_SEND = "https://qyapi.weixin.qq.com/cgi-bin/kf/send?access_token=";
	private static final String API_KF_LIST = "https://qyapi.weixin.qq.com/cgi-bin/kf/list?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * 向企业号客服发送客服消息
	 * 该接口用于向客服人员发送消息，支持文本、图片、文件消息。
	 * sender和receiver有且只有一个类型为kf。当receiver为kf时，表示向客服发送用户咨询的问题消息。
	 * 当sender为kf时，表示客服从其它IM工具回复客户，并同步消息到客服的微信上
	 * @param kfSend
	 * @return {ApiResult}
	 */
	public static ApiResult sendKf(KfSendParam kfSend) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_KF_SEND + token, "POST", JsonUtil.toJson(kfSend));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 向企业号客服发送客服消息
	 * 该接口用于向客服人员发送消息，支持文本、图片、文件消息。
	 * sender和receiver有且只有一个类型为kf。当receiver为kf时，表示向客服发送用户咨询的问题消息。
	 * 当sender为kf时，表示客服从其它IM工具回复客户，并同步消息到客服的微信上
	 * @param kfSend
	 * @param token
	 * @return {ApiResult}
	 */
	public static ApiResult sendKf(KfSendParam kfSend, String token) {
		String json = HttpUtil.httpsRequest(API_KF_SEND + token, "POST", JsonUtil.toJson(kfSend));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 获取客服列表
	 * @param type
	 * 						客服类型
	 *							1. internal 只获取内部客服列表
	 *							2. external 只获取外部客服列表
	 *							不填时，同时返回内部、外部客服列表 
	 * @return {KfListResult}
	 */
	public static KfListResult listKf(String type) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_KF_LIST.replace("ACCESS_TOKEN", token).replace("TYPE", type), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, KfListResult.class);
		}
		return null;
	}
	
	/**
	 * 获取客服列表
	 * @param type
	 * 						客服类型
	 *							1. internal 只获取内部客服列表
	 *							2. external 只获取外部客服列表
	 *							不填时，同时返回内部、外部客服列表 
	 * @param token
	 * @return {KfListResult}
	 */
	public static KfListResult listKf(String type, String token) {
		String json = HttpUtil.httpsRequest(API_KF_LIST.replace("ACCESS_TOKEN", token).replace("TYPE", type), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, KfListResult.class);
		}
		return null;
	}
}
