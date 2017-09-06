package cc.walker.qyweixin.api;

import cc.walker.qyweixin.api.req.AsyncReqParam;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.api.result.BatchGetResult;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 异步任务接口 通讯录更新
 * 
 * 通讯录更新接口提供三种更新方法：1) 增量更新成员 2）全量覆盖成员 3) 全量覆盖部门。<br/>
 * 如果企业要做到与企业号通讯录完全一致，可先调用全量覆盖部门接口，再调用全量覆盖成员接口，<br/>
 * 即可保持通讯录完全一致。<br/>
 * 使用步骤为：<br/>
 * 1.下载接口对应的csv模板，如果有扩展字段，请自行添加<br/>
 * 2.按模板的格式，生成接口所需的数据文件<br/>
 * 3.通过上传媒体文件接口上传数据文件，获取media_id<br/>
 * 4.调用通讯录更新接口，传入media_id参数<br/>
 * 5.接收任务完成事件，并获取任务执行结果<br/>
 * 
 * @author walker
 * @date 2016-09-14
 */
public class AsynApi {

	private static final String API_BATCH_SYNCUSER = "https://qyapi.weixin.qq.com/cgi-bin/batch/syncuser?access_token=";
	private static final String API_BATCH_REPLACEUSER = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceuser?access_token=";
	private static final String API_BATCH_REPLACEPARTY = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceparty?access_token=";
	private static final String API_BATCH_GETRESULT = "https://qyapi.weixin.qq.com/cgi-bin/batch/getresult?access_token=ACCESS_TOKEN&jobid=JOBID";
	
	/**
	 * 增量更新成员
	 * 
	 * 权限说明：管理组须拥有指定成员的管理权限。
	 * 
	 * 接口说明：
	 * 本接口以userid为主键，增量更新企业号通讯录成员。请先下载CSV模板(下载增量更新成员模版)，根据需求填写文件内容。
	 * 注意事项：
	 * 1.模板中的部门需填写部门ID，多个部门用分号分隔，部门ID必须为数字
	 * 2.文件中存在、通讯录中也存在的成员，更新成员在文件中指定的字段值
	 * 3.文件中存在、通讯录中不存在的成员，执行添加操作
	 * 4.通讯录中存在、文件中不存在的成员，保持不变
	 * 5.成员字段更新规则：文件中有指定的字段，以指定的字段值为准；文件中没指定的字段，不更新
	 * 
	 * @param reqParam 请求参数
	 * @return {ApiResult}
	 */
	public static ApiResult syncuser(AsyncReqParam reqParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_BATCH_SYNCUSER + token,
				"POST", JsonUtil.toJson(reqParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	

    /**
     * 全量覆盖成员
     * 
     * 权限说明:管理组须拥有根部门的管理权限。
     * 
     * 接口说明
     * 本接口以userid为主键，全量覆盖企业号通讯录成员，任务完成后企业号通讯录成员与提交的文件完全保持一致。请先下载CSV文件(下载全量覆盖成员模版)，根据需求填写文件内容。
     * 注意事项：
     * 1.模板中的部门需填写部门ID，多个部门用分号分隔，部门ID必须为数字
     * 2.文件中存在、通讯录中也存在的成员，完全以文件为准
     * 3.文件中存在、通讯录中不存在的成员，执行添加操作
     * 4.通讯录中存在、文件中不存在的成员，执行删除操作。出于安全考虑，如果:
     * 	a) 需要删除的成员多于50人，且多于现有人数的20%以上
     * 	b) 需要删除的成员少于50人，且多于现有人数的80%以上
     * 系统将中止导入并返回相应的错误码
     * 5.成员字段更新规则：文件中有指定的字段，以指定的字段值为准；文件中没指定的字段，不更新
     */
	public static ApiResult replaceuser(AsyncReqParam reqParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_BATCH_REPLACEUSER + token,
				"POST", JsonUtil.toJson(reqParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
     * 全量覆盖部门
     * 
     * 权限说明:管理组须拥有根部门的管理权限。
     * 
     * 接口说明
	 * 本接口以partyid为键，全量覆盖企业号通讯录组织架构，任务完成后企业号通讯录组织架构与提交的文件完全保持一致。请先下载CSV文件(下载全量覆盖部门模版)，根据需求填写文件内容。
	 * 注意事项：
	 * 1.文件中存在、通讯录中也存在的部门，执行修改操作
	 * 2.文件中存在、通讯录中不存在的部门，执行添加操作
	 * 3.文件中不存在、通讯录中存在的部门，当部门下没有任何成员或子部门时，执行删除操作
	 * 4.CSV文件中，部门名称、部门ID、父部门ID为必填字段，部门ID必须为数字；排序为可选字段，置空或填0不修改排序
     */
	public static ApiResult replaceparty(AsyncReqParam reqParam) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_BATCH_REPLACEPARTY + token,
				"POST", JsonUtil.toJson(reqParam));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 获取异步任务结果 权限说明：管理组曾经提交相应的任务。 
	 * 
	 * @return {BatchGetResult}
	 */
	public static BatchGetResult getResult() {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_BATCH_GETRESULT + token,
				"GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, BatchGetResult.class);
		}
		return null;
	}
}
