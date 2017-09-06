package cc.walker.qyweixin.api;

import cc.walker.qyweixin.api.req.ChatClearNotifyParam;
import cc.walker.qyweixin.api.req.ChatCreateParam;
import cc.walker.qyweixin.api.req.ChatQuitParam;
import cc.walker.qyweixin.api.req.ChatSendParam;
import cc.walker.qyweixin.api.req.ChatSetMuteParam;
import cc.walker.qyweixin.api.req.ChatUpdateParam;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.api.result.ChatGetResult;
import cc.walker.qyweixin.api.result.ChatSetMuteResult;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 企业会话接口
 * @author walker
 * @date 2016-09-21
 */
public class ChatApi {

	private static final String API_CHAT_CREATE = "https://qyapi.weixin.qq.com/cgi-bin/chat/create?access_token=";
	private static final String API_CHAT_GET = "https://qyapi.weixin.qq.com/cgi-bin/chat/get?access_token=ACCESS_TOKEN&chatid=CHATID";
	private static final String API_CHAT_UPDATE = "https://qyapi.weixin.qq.com/cgi-bin/chat/update?access_token=";
	private static final String API_CHAT_QUIT = "https://qyapi.weixin.qq.com/cgi-bin/chat/quit?access_token=";
	private static final String API_CHAT_CLEARNOTIFY = "https://qyapi.weixin.qq.com/cgi-bin/chat/clearnotify?access_token=";
	private static final String API_CHAT_SEND = "https://qyapi.weixin.qq.com/cgi-bin/chat/send?access_token=";
	private static final String API_CHAT_SETMUTE = "https://qyapi.weixin.qq.com/cgi-bin/chat/setmute?access_token=";
	
	/**
	 * 创建会话
	 * @param chatCreateParam
	 * @return
	 */
	public static ApiResult createChat(ChatCreateParam chatCreateParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_CREATE + token, "POST", JsonUtil.toJson(chatCreateParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 获取会话
	 * @param chatId
	 * @return
	 */
	public static ChatGetResult getChat(String chatId) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_GET.replace("ACCESS_TOKEN", token).replace("CHATID", chatId), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, ChatGetResult.class);
		}
		return null;
	}
	
	/**
	 * 修改会话信息
	 * @param chatUpdateParam
	 * @return
	 */
	public static ApiResult updateChat(ChatUpdateParam chatUpdateParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_UPDATE + token, "POST", JsonUtil.toJson(chatUpdateParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 修改会话信息
	 * @param chatUpdateParam
	 * @return
	 */
	public static ApiResult clearnotifyChat(ChatClearNotifyParam chatUpdateParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_CLEARNOTIFY+ token, "POST", JsonUtil.toJson(chatUpdateParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 退出会话
	 * @param chatQuitParam
	 * @return
	 */
	public static ApiResult quitChat(ChatQuitParam chatQuitParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_QUIT + token, "POST", JsonUtil.toJson(chatQuitParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 清除会话未读状态
	 * @param chatClearNotifyParam
	 * @return
	 */
	public static ApiResult quitChat(ChatClearNotifyParam chatClearNotifyParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_CLEARNOTIFY + token, "POST", JsonUtil.toJson(chatClearNotifyParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 发消息
	 * 消息支持文本、图片、文件，在发送时需要区分群聊和单聊。如果接收人不存在，则发送失败。
	 * 在企业IM端发送的消息，在同步到发送者的微信上时，不会有提醒
	 * @param chatSendParam
	 * @return {ApiResult}
	 */
	public static ApiResult sendChat(ChatSendParam chatSendParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_SEND + token, "POST", JsonUtil.toJson(chatSendParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 设置成员新消息免打扰
	 * 该接口可设置成员接收到的消息是否提醒。主要场景是用于对接企业im的在线状态，
	 * 如成员处于在线状态时，可以设置该成员的消息免打扰。
	 * 当成员离线时，关闭免打扰状态，对微信端进行提醒。
	 * 
	 * @param param
	 * @return
	 */
	public static ChatSetMuteResult setMute(ChatSetMuteParam param) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_CHAT_SETMUTE + token, "POST", JsonUtil.toJson(param));
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, ChatSetMuteResult.class);
		}
		return null;
	}
}
