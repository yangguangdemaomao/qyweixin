package cc.walker.qyweixin.api;

import cc.walker.qyweixin.aes.AesException;
import cc.walker.qyweixin.aes.WXBizMsgCrypt;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.cnst.QyWechatConfig;
import cc.walker.qyweixin.msg.resp.initiative.OutBaseMsg;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 消息发送接口
 * 
 * @author walker
 * @date 2016-09-08
 */
public class MsgApi {

	private static final String API_MESSAGE_SEND = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
	
	/**
	 * 发送消息给企业用户（主动发送）
	 * 权限说明：收件人必须处于应用的可见范围内，并且管理组对应用有使用权限、对收件人有查看权限，否则本次调用失败。
	 * @param outMsg 消息基础类
	 * @return ApiResult 调用发送接口返回内容
	 */
	public static ApiResult sendMsg(OutBaseMsg outMsg) {
		String token = TokenManager.getToken();
		String postJson = JsonUtil.toJson(outMsg);
		String json = HttpUtil.httpsRequest(API_MESSAGE_SEND + token, "POST", postJson);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 发送消息(加密)给企业用户（主动发送）
	 * 权限说明：收件人必须处于应用的可见范围内，并且管理组对应用有使用权限、对收件人有查看权限，否则本次调用失败。
	 * @param outMsg 消息基础类
	 * @param timeStamp
	 * @param nonce
	 * @return ApiResult 调用发送接口返回内容
	 */
	public static ApiResult sendEncryptMsg(OutBaseMsg outMsg, String timeStamp, String nonce) {
		String sToken = TokenManager.getToken();
		String sCorpID = QyWechatConfig.getCorpid();
		String sEncodingAESKey = QyWechatConfig.getEncodingAESKey();
		String postJson = "";
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			postJson = wxcpt.EncryptMsg(JsonUtil.toJson(outMsg), timeStamp, nonce);
		} catch (AesException e) {
			e.printStackTrace();
		}
		String json = HttpUtil.httpsRequest(API_MESSAGE_SEND + sToken, "POST", postJson);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
}
