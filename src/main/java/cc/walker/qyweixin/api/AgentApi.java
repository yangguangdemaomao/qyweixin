package cc.walker.qyweixin.api;

import cc.walker.qyweixin.api.req.AgentSet;
import cc.walker.qyweixin.api.result.AgentGetResult;
import cc.walker.qyweixin.api.result.AgentListResult;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.cnst.QyWechatConfig;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 企业开发者可以通过接口实现对应用的头像、名称、简介设置，也可通过接口开启或关闭应用的功能开关。
 * 目前提供获取企业号应用、设置企业号应用、获取应用列表的接口。 
 * 
 * @author walker
 * @date 2016-09-07
 */
public class AgentApi {

	//获取企业号应用信息接口
	private static final String API_AGENT_GET = "https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//设置企业号应用接口
	private static final String API_AGENT_SET = "https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token=";
	//获取企业号应用列表接口
	private static final String API_AGENT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=";
	
	/**
	 * 根据应用id，获取应用详细信息
	 * 权限说明：管理组须拥有指定应用的发消息权限。
	 * @return {AgentGetResult}
	 */
	public static AgentGetResult getAgent() {
		AgentGetResult result = null;
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_AGENT_GET.replace("ACCESS_TOKEN", token).replace("AGENTID", QyWechatConfig.getAppid()), "GET", null);
		if (StrUtil.notBlank(json)) {
			result = JsonUtil.fromJson(json, AgentGetResult.class);
		}
		return result;
	}
	
	/**
	 * 设置企业号应用
	 * 该API用于设置企业应用的选项设置信息，如：地理位置上报等。第三方服务商不能调用该接口设置授权的主页型应用。
	 * 权限说明：管理组须拥有指定应用的配置权限。
	 * @param agent(应用信息)
	 * @return {ApiResult}
	 */
	public static ApiResult setAgent(AgentSet agent) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_AGENT_SET + token, "POST", JsonUtil.toJson(agent));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 获取应用概况列表
	 * 权限说明：该接口只返回调用管理组内的应用列表
	 * @return {AgentListResult}
	 */
	public static AgentListResult listAgent() {
		AgentListResult result = null;
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_AGENT_LIST + token, "GET", null);
		if (StrUtil.notBlank(json)) {
			result = JsonUtil.fromJson(json, AgentListResult.class);
		}
		return result;
	}
}
