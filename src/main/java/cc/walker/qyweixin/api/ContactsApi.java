package cc.walker.qyweixin.api;

import java.util.List;

import cc.walker.qyweixin.api.req.Department;
import cc.walker.qyweixin.api.req.Tag;
import cc.walker.qyweixin.api.req.TagUsers;
import cc.walker.qyweixin.api.req.User;
import cc.walker.qyweixin.api.req.UserList;
import cc.walker.qyweixin.api.result.DepartListResult;
import cc.walker.qyweixin.api.result.TagListResult;
import cc.walker.qyweixin.api.result.TagUserResult;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.api.result.TagGetResult;
import cc.walker.qyweixin.api.result.UserGetResult;
import cc.walker.qyweixin.api.result.UserListResult;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.HttpUtil;
import cc.walker.qyweixin.util.JsonUtil;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 企业号通讯录具备完全开放的接口，你的应用可以调用这些接口管理部门、成员和标签。 你的应用也可以使用部门、成员、标签发消息，或更改应用的可见范围。
 * 
 * @author walker
 * @date 2016-09-13
 */
public class ContactsApi {

	// 管理部门
	private static final String API_USER_AUTHSUCC = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=ACCESS_TOKEN&userid=USERID";
	private static final String API_DEPARTMENT_CREATE = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=";
	private static final String API_DEPARTMENT_UPDATE = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=";
	private static final String API_DEPARTMENT_DELETE = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID";
	private static final String API_DEPARTMENT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";
	// 管理成员
	private static final String API_USER_CREATE = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=";
	private static final String API_USER_UPDATE = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=";
	private static final String API_USER_DELETE = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID";
	private static final String API_USER_BATCHDELETE = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=";
	private static final String API_USER_GET = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
	private static final String API_USER_SIMPLELIST = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";
	private static final String API_USER_LIST = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";
	// 管理标签
	private static final String API_TAG_CREATE = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=";
	private static final String API_TAG_UPDATE = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=";
	private static final String API_TAG_DELETE = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=TAGID";
	private static final String API_TAG_GET = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAGID";
	private static final String API_TAG_ADDTAGUSERS = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=";
	private static final String API_TAG_DELTAGUSERS = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=";
	private static final String API_TAG_LIST = "https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=";

	/**
	 * 二次验证 权限说明：管理员须拥有userid对应成员的管理权限。
	 * 
	 * @param userid
	 *            (用户id)
	 * @return {ApiResult}
	 */
	public static ApiResult authsuccUser(String userid) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_USER_AUTHSUCC.replace("ACCESS_TOKEN", token).replace(
						"USERID", userid), "GET", null);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 创建部门 权限说明：管理组须拥有父部门的管理权限。
	 * 
	 * @param department
	 * @return {ApiResult}
	 */
	public static ApiResult createDepartment(Department department) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_DEPARTMENT_CREATE + token,
				"POST", JsonUtil.toJson(department));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 更新部门 权限说明：管理组需拥有指定部门的管理权限
	 * 
	 * @param department
	 * @return {ApiResult}
	 */
	public static ApiResult updateDepartment(Department department) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_DEPARTMENT_UPDATE + token,
				"POST", JsonUtil.toJson(department));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 删除部门 权限说明：管理组需拥有指定部门的管理权限
	 * 
	 * @param id
	 * @return {ApiResult}
	 */
	public static ApiResult deleteDepartment(int id) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_DEPARTMENT_DELETE.replace("ACCESS_TOKEN", token).replace(
						"ID", id + ""), "GET", null);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}
	
	/**
	 * 根据部门id获取部门列表
	 * @param id 部门id
	 * @return
	 */
	public static DepartListResult listDepartment(int id) {
		return listDepartment(id+"");
	}
	
	/**
	 * 获取所有部门列表
	 * @return
	 */
	public static DepartListResult listAllDepartment() {
		return listDepartment("");
	}
	
	/**
	 * 获取部门列表
	 * @param id
	 * @return
	 */
	private static DepartListResult listDepartment(String id) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_DEPARTMENT_LIST.replace("ACCESS_TOKEN", token).replace(
						"ID", id), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, DepartListResult.class);
		}
		return null;
	}

	/**
	 * 创建用户 权限说明：管理组需拥有指定部门的管理权限
	 * 
	 * @param user
	 * @return {ApiResult}
	 */
	public static ApiResult createUser(User user) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_USER_CREATE + token, "POST",
				JsonUtil.toJson(user));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 更新用户 权限说明：管理组需拥有指定部门的管理权限
	 * 
	 * @param user
	 * @return {ApiResult}
	 */
	public static ApiResult updateUser(User user) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_USER_UPDATE + token, "POST",
				JsonUtil.toJson(user));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 删除用户 权限说明：管理组需拥有指定部门的管理权限
	 * 
	 * @param userid
	 * @return {ApiResult}
	 */
	public static ApiResult deleteUser(String userid) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_USER_DELETE.replace("ACCESS_TOKEN", token).replace(
						"USERID", userid), "GET", null);
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 批量删除用户 权限说明：管理组需拥有指定部门的管理权限
	 * 
	 * @param userid
	 * @return {ApiResult}
	 */
	public static ApiResult batchdeleteUser(List<String> useridlist) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(API_USER_BATCHDELETE + token,
				"POST", JsonUtil.toJson(new UserList(useridlist)));
		if (StrUtil.notBlank(json)) {
			return new ApiResult(json);
		}
		return null;
	}

	/**
	 * 获取用户信息 权限说明：管理组须拥有指定成员的查看权限。
	 * 
	 * @param userid
	 * @return
	 */
	public static UserGetResult getUser(String userid) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_USER_GET.replace("ACCESS_TOKEN", token).replace("USERID",
						userid), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, UserGetResult.class);
		}
		return null;
	}

	/**
	 * 获取部门成员 权限说明：管理组须拥有指定部门的查看权限。
	 * 
	 * @param departmentId
	 *            获取的部门id
	 * @param fetchChild
	 *            1/0：是否递归获取子部门下面的成员
	 * @return {UserSimpleListResult}
	 */
	public static UserListResult simplelistUser(int departmentId,
			int fetchChild) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_USER_SIMPLELIST.replace("ACCESS_TOKEN", token)
						.replace("DEPARTMENT_ID", departmentId + "")
						.replace("FETCH_CHILD", fetchChild + ""), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, UserListResult.class);
		}
		return null;
	}

	/**
	 * 获取部门成员 权限说明：管理组须拥有指定部门的查看权限。
	 * 
	 * @param departmentId
	 *            获取的部门id
	 * @param fetchChild
	 *            1/0：是否递归获取子部门下面的成员
	 * @return {UserSimpleListResult}
	 */
	public static UserListResult listUser(int departmentId, int fetchChild) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_USER_LIST.replace("ACCESS_TOKEN", token)
						.replace("DEPARTMENT_ID", departmentId + "")
						.replace("FETCH_CHILD", fetchChild + ""), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, UserListResult.class);
		}
		return null;
	}

	/**
	 * 创建tag 权限说明：创建的标签属于管理组，默认为加锁状态。加锁状态下只有本管理组才可以增删成员，解锁状态下其它管理组也可以增删成员。
	 * 
	 * @param tag
	 *            需要创建的tag
	 * @return {ApiResult}
	 */
	public static ApiResult createTag(Tag tag) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_CREATE + token, "POST", JsonUtil.toJson(tag));
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, ApiResult.class);
		}
		return null;
	}
	
	/**
	 * 更新tag 权限说明：管理组必须是指定标签的创建者。
	 * 
	 * @param tag
	 *            需要更新的tag
	 * @return {ApiResult}
	 */
	public static ApiResult updateTag(Tag tag) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_UPDATE + token, "POST", JsonUtil.toJson(tag));
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, ApiResult.class);
		}
		return null;
	}
	
	/**
	 * 创建tag 权限说明：管理组必须是指定标签的创建者。
	 * 
	 * @param tagid
	 *            需要删除的tagid
	 * @return {ApiResult}
	 */
	public static ApiResult deleteTag(int tagid) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_DELETE.replace("ACCESS_TOKEN", token).replace("TAGID", tagid+""), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, ApiResult.class);
		}
		return null;
	}
	
	/**
	 * 获取tag 权限说明：无限制，但返回列表仅包含管理组管辖范围的成员。
	 * 
	 * @param tagid
	 *            需要获取的tagid
	 * @return {TagGetResult}
	 */
	public static TagGetResult getTag(int tagid) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_GET.replace("ACCESS_TOKEN", token).replace("TAGID", tagid+""), "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, TagGetResult.class);
		}
		return null;
	}
	
	/**
	 * 增加标签成员 权限说明：管理组是指定标签的创建者，或标签未加锁；成员属于管理组管辖范围。
	 * 
	 * @param tagusers
	 *            需要添加的tagusers
	 * @return {AddTagUserResult}
	 *				<p>返回结果</p>
	 *			    <p>a)正确时返回</p>
	 *				<p>{</p>
	 *				   <p>"errcode": 0,</p>
	 *				   <p>"errmsg": "deleted"</p>
	 *				<p>}</p>
	 *				<p>b)若部分userid、partylist非法，则返回</p>
	 *				<p>{</p>
	 *				   <p>"errcode": 0,</p>
	 *				  <p> "errmsg": "错误消息",</p>
	 *				   <p>"invalidlist"："usr1|usr2|usr",</p>
	 *				   <p>"invalidparty": [2,4]</p>
	 *				<p>}</p>
	 *				<p>其中错误消息视具体出错情况而定，分别为：</p>
	 *				<p>invalid userlist and partylist faild</p>
	 *				<p>invalid userlist faild</p>
	 *				<p>invalid partylist faild</p>
	 *				<p>c)当包含的userid、partylist全部非法时返回</p>
	 *				<p>{</p>
	 *				  <p> "errcode": 40031,</p>
	 *				  <p> "errmsg": "all list invalid"</p>
	 *				<p>}</p>
	 */
	public static TagUserResult addTagUsers(TagUsers tagusers) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_ADDTAGUSERS + token, "POST", JsonUtil.toJson(tagusers));
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, TagUserResult.class);
		}
		return null;
	}
	
	/**
	 * 删除标签成员 权限说明：管理组是指定标签的创建者，或标签未加锁；成员属于管理组管辖范围。
	 * 
	 * @param tagusers
	 *            需要删除的tagusers
	 * @return {AddTagUserResult}
     *				<p>返回结果</p>
	 *			    <p>a)正确时返回</p>
	 *				<p>{</p>
	 *				   <p>"errcode": 0,</p>
	 *				   <p>"errmsg": "deleted"</p>
	 *				<p>}</p>
	 *				<p>b)若部分userid、partylist非法，则返回</p>
	 *				<p>{</p>
	 *				   <p>"errcode": 0,</p>
	 *				  <p> "errmsg": "错误消息",</p>
	 *				   <p>"invalidlist"："usr1|usr2|usr",</p>
	 *				   <p>"invalidparty": [2,4]</p>
	 *				<p>}</p>
	 *				<p>其中错误消息视具体出错情况而定，分别为：</p>
	 *				<p>invalid userlist and partylist faild</p>
	 *				<p>invalid userlist faild</p>
	 *				<p>invalid partylist faild</p>
	 *				<p>c)当包含的userid、partylist全部非法时返回</p>
	 *				<p>{</p>
	 *				  <p> "errcode": 40031,</p>
	 *				  <p> "errmsg": "all list invalid"</p>
	 *				<p>}</p>
	 */
	public static TagUserResult delTagUsers(TagUsers tagusers) {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_DELTAGUSERS + token, "POST", JsonUtil.toJson(tagusers));
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, TagUserResult.class);
		}
		return null;
	}
	
	/**
	 * 获取标签列表
	 * 
	 * @return {TagListResult}
	 */
	public static TagListResult listTag() {
		String token = TokenManager.getToken();
		String json = HttpUtil.httpsRequest(
				API_TAG_LIST + token, "GET", null);
		if (StrUtil.notBlank(json)) {
			return JsonUtil.fromJson(json, TagListResult.class);
		}
		return null;
	}
}
