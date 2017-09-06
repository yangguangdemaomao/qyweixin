package cc.walker.qyweixin.api.req;

/**
 * 创建机构接口参数
 * access_token 	调用接口凭证
 * agentid 	企业应用的id
 * report_location_flag 	企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报
 * logo_mediaid 	企业应用头像的mediaid，通过多媒体接口上传图片获得mediaid，上传后会自动裁剪成方形和圆形两个头像 
 * name 	企业应用名称
 * description 	企业应用详情
 * redirect_domain 	企业应用可信域名
 * isreportuser 	是否接收用户变更通知。0：不接收；1：接收。
 * isreportenter 	是否上报用户进入应用事件。0：不接收；1：接收。
 * home_url 	主页型应用url。url必须以http或者https开头。消息型应用无需该参数
 * chat_extension_url 	关联会话url。设置该字段后，企业会话"+"号将出现该应用，点击应用可直接跳转到此url，支持jsapi向当前会话发送消息。 
 * 
 * @author walker
 *
 */
public class AgentSet {

	private Integer agentid;
	private Integer report_location_flag;
	private String logo_mediaid;
	private String name;
	private String description;
	private String redirect_domain;
	private Integer isreportuser;
	private Integer isreportenter;
	private String home_url;
	private String chat_extension_url;

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public Integer getReport_location_flag() {
		return report_location_flag;
	}

	public void setReport_location_flag(Integer report_location_flag) {
		this.report_location_flag = report_location_flag;
	}

	public String getLogo_mediaid() {
		return logo_mediaid;
	}

	public void setLogo_mediaid(String logo_mediaid) {
		this.logo_mediaid = logo_mediaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRedirect_domain() {
		return redirect_domain;
	}

	public void setRedirect_domain(String redirect_domain) {
		this.redirect_domain = redirect_domain;
	}

	public Integer getIsreportuser() {
		return isreportuser;
	}

	public void setIsreportuser(Integer isreportuser) {
		this.isreportuser = isreportuser;
	}

	public Integer getIsreportenter() {
		return isreportenter;
	}

	public void setIsreportenter(Integer isreportenter) {
		this.isreportenter = isreportenter;
	}

	public String getHome_url() {
		return home_url;
	}

	public void setHome_url(String home_url) {
		this.home_url = home_url;
	}

	public String getChat_extension_url() {
		return chat_extension_url;
	}

	public void setChat_extension_url(String chat_extension_url) {
		this.chat_extension_url = chat_extension_url;
	}
}
