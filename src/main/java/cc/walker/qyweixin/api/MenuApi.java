package cc.walker.qyweixin.api;

import cc.walker.qyweixin.api.req.Menu;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.cnst.QyWechatConfig;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 目前自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。一级菜单最多4个汉字，二级菜单最多7个汉字，
 * 多出来的部分将会以“...”代替。请注意，创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。
 * 建议测试时可以尝试取消关注企业号后再次关注，则可以看到创建后的效果。
 * 
 * 字段值 	                         功能名称 	                        说明
 * click 	                             点击推事件 	                    成员点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event 的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与成员进行交互；
 * view 	                             跳转URL 	                        成员点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取成员基本信息接口结合，获得成员基本信息。
 * scancode_push 	         扫码推事件 	                    成员点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
 * scancode_waitmsg 	 扫码推事件且弹出“消息接收中”提示框 	成员点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
 * pic_sysphoto 	             弹出系统拍照发图 	        成员点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
 * pic_photo_or_album 弹出拍照或者相册发图 	成员点击按钮后，微信客户端将弹出选择器供成员选择“拍照”或者“从手机相册选择”。成员选择后即走其他两种流程。
 * pic_weixin 	                 弹出微信相册发图器 	    成员点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
 * location_select 	         弹出地理位置选择器 	    成员点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。 
 * 
 * @author walker
 * @date 2016-09-13
 */
public class MenuApi {

	//创建菜单
	private static final String API_MENU_CREATE = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//删除菜单
	private static final String API_MENU_DELETE = "https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//菜单列表
	private static final String API_MENU_GET = "https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN&agentid=AGENTID";
	
	/**
	 * 创建菜单
	 * 权限说明：管理组须拥有应用的管理权限，并且应用必须设置在回调模式。
	 * @param menu
	 * @return
	 */
	public static ApiResult createMenu(Menu menu) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MENU_CREATE.replace("ACCESS_TOKEN", token).replace("AGENTID", QyWechatConfig.getAppid()), "POST", JsonUtil.toJson(menu));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 删除菜单
	 * 权限说明：管理组须拥有应用的管理权限，并且应用必须设置在回调模式。
	 * @param menu
	 * @return
	 */
	public static ApiResult deleteMenu() {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MENU_DELETE.replace("ACCESS_TOKEN", token).replace("AGENTID", QyWechatConfig.getAppid()), "GET", null);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 获取应用菜单
	 * 权限说明：管理组须拥有应用的使用权限，并且应用必须设置在回调模式。
	 * @return {Menu}
	 */
	public static Menu getMenu() {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MENU_GET.replace("ACCESS_TOKEN", token).replace("AGENTID", QyWechatConfig.getAppid()), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, Menu.class);
		}
		return null;
	}
}
