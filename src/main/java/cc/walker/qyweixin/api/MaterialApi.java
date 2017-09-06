package cc.walker.qyweixin.api;

import java.io.File;

import cc.walker.qyweixin.api.req.MaterialBatchGetParam;
import cc.walker.qyweixin.api.req.Mpnews;
import cc.walker.qyweixin.api.req.MpnewsUpdate;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.api.result.MaterialBatchGetResult;
import cc.walker.qyweixin.api.result.MaterialGetResult;
import cc.walker.qyweixin.api.result.MediaGetResult;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 素材管理api
 * 
 * 企业可以使用素材管理的接口将多媒体文件上传到素材库，素材库归管理组所有。素材库可包含图片、音频、视频、文件以及图文消息。对多媒体文件、多媒体消息素材的获取和调用等操作，是通过media_id来进行的。素材包括两种：
 * 临时素材文件：（media_id）会在上传到微信服务器3天后自动删除，以节省服务器资源。
 * 永久素材文件：（media_id）会一直保存在微信服务器上，但是对企业能够保存的永久素材数量有所限制: 整个企业图文消息素材和图片素材数目的上限分别为5000，其他类型为1000.
 * 
 * @author walker
 * @date 2016-09-14
 */
public class MaterialApi {
	
	private static final String API_MEDIA_UPLOAD = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private static final String API_MEDIA_GET = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	private static final String API_MATERIAL_DEL = "https://qyapi.weixin.qq.com/cgi-bin/material/del?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	private static final String API_MATERIAL_ADD_MPNEWS = "https://qyapi.weixin.qq.com/cgi-bin/material/add_mpnews?access_token=";
	private static final String API_MATERIAL_ADD_MATERIAL = "https://qyapi.weixin.qq.com/cgi-bin/material/add_material?type=TYPE&access_token=ACCESS_TOKEN";
	private static final String API_MATERIAL_UPDATE_MPNEWS = "https://qyapi.weixin.qq.com/cgi-bin/material/update_mpnews?access_token=";
	private static final String API_MATERIAL_GET = "https://qyapi.weixin.qq.com/cgi-bin/material/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	private static final String API_MATERIAL_GET_COUNT = "https://qyapi.weixin.qq.com/cgi-bin/material/get_count?access_token=";
	private static final String API_MATERIAL_BATCHGET = "https://qyapi.weixin.qq.com/cgi-bin/material/batchget?access_token=";
	private static final String API_MATERIAL_UPLOADIMG = "https://qyapi.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";
	
	/**
	 * 上传临时素材文件
	 * 
	 * 权限说明：完全公开。所有管理组均可调用，素材归管理组所有。
	 * 
	 * 文件限制：
	 * 所有文件size必须大于5个字节
	 * 图片（image）:2MB，支持JPG,PNG格式
	 * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式
	 * 视频（video）：10MB，支持MP4格式
	 * 普通文件（file）：20MB
	 * 整个企业图文消息素材和图片素材数目的上限为5000，其他类型为1000
	 * 超出素材数量限制返回错误码45028
	 * 
	 * @return {ApiResult}
	 */
	public static ApiResult uploadMedia(File f, String type) {
		String token = TokenManager.getToken();
		String json = HttpUtil.postFile(API_MEDIA_UPLOAD.replace("ACCESS_TOKEN", token).replace("TYPE", type), f);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 通过media_id获取图片、语音、视频等文件，协议和普通的http文件下载完全相同。该接口即原"下载多媒体文件"接口。
	 * 
	 * @param mediaId
	 * @return {MediaGetResult}
	 */
	public static MediaGetResult getMedia(String mediaId) {
		String token = TokenManager.getToken();
		return HttpUtil.getMedia(API_MEDIA_GET.replace("ACCESS_TOKEN", token).replace("MEDIA_ID", mediaId));
	}
	
	/**
	 * 通过media_id删除上传的图文消息、图片、语音、文件、视频素材。
	 * 权限说明：所有管理组均可调用。
	 * 
	 * @param mediaId  要删除的media_id
	 * @return {ApiResult}
	 */
	public static ApiResult delMaterial(String mediaId) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MATERIAL_DEL.replace("ACCESS_TOKEN", token).replace("MEDIA_ID", mediaId), "GET", null);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 上传永久素材：
	 * 用于上传图文消息素材，接口返回素材资源标识ID：media_id。media_id是可复用的，同一个media_id可用于消息的多次发送。
	 * 使用永久图文素材ID发送消息参见：mpnews消息发送说明
	 * 
	 * 权限说明：所有管理组均可调用，素材归管理组所有。
	 * 
	 * @param mpnews
	 * @return {ApiResult}
	 * 						return content is 
	 * 						{
     *							errcode": "0",
     *							errmsg": "ok",
     *							media_id": "2-G6nrLmr5EC3MMfasdfb_-zK1dDdzmd0p7"
	 *							}
	 */
	public static ApiResult addMpnews(Mpnews mpnews) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MATERIAL_ADD_MPNEWS + token, "POST", JsonUtil.toJson(mpnews));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 永久素材：
	 * 用于上传图片、语音、视频等媒体资源文件以及普通文件（如doc，ppt），接口返回素材资源标识ID：media_id。
	 * media_id是可复用的，同一个media_id可用于消息的多次发送。
	 * 
	 * @param f
	 * @param type
	 * @return
	 */
	public static ApiResult addMaterial(File f, String type) {
		String token = TokenManager.getToken();
		String json = HttpUtil.postFile(API_MATERIAL_ADD_MATERIAL.replace("ACCESS_TOKEN", token).replace("TYPE", type), f);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 获取永久素材
	 * 通过media_id获取上传的图文消息、图片、语音、文件、视频素材。
	 * 
	 * @param mediaId
	 * @return
	 */
	public static MaterialGetResult getMaterial(String mediaId) {
		String token = TokenManager.getToken();
		return HttpUtil.getMaterial(API_MATERIAL_GET.replace("ACCESS_TOKEN", token).replace("MEDIA_ID", mediaId));
	}
	
	/**
	 * 获取素材总数：本接口可以获取当前管理组的素材总数以及每种类型素材的数目。
	 * @return {ApiResult}
	 */
	public static ApiResult getCount() {
			String token = TokenManager.getToken();
			String json = HttpUtil.httpsRequest(API_MATERIAL_GET_COUNT + token, "GET", null);
			if (StrUtil.notBlank(json)) {
				return new ApiResult(json);
			}
			return null;
	}
	
	/**
	 * 修改永久素材：通过本接口对永久图文素材进行修改。
	 * @param mpnews
	 * @return
	 */
	public static ApiResult updateMaterial(MpnewsUpdate mpnews) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MATERIAL_UPDATE_MPNEWS + token, "POST", JsonUtil.toJson(mpnews));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 获取素材列表：本接口可以获取当前管理组指定类型的素材列表
	 * @param param
	 * @return {MaterialBatchGetResult}
	 */
	public static MaterialBatchGetResult batchGet(MaterialBatchGetParam param) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_MATERIAL_BATCHGET + token, "POST", JsonUtil.toJson(param));
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, MaterialBatchGetResult.class);
		}
		return null;
	}
	
	/**
	 * 上传图文消息内的图片:用于上传图片到企业号服务端，接口返回图片url，请注意，该url仅可用于图文消息的发送，
	 * 且每个企业每天最多只能上传100张图片。
	 * @param f
	 * @return
	 */
	public static ApiResult uploadImg(File f) {
		String token = TokenManager.getToken();
		String json = HttpUtil.postFile(API_MATERIAL_UPLOADIMG.replace("ACCESS_TOKEN", token), f);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
}
