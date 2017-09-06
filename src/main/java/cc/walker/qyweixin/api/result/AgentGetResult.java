package cc.walker.qyweixin.api.result;

public class AgentGetResult implements Result {

	private Integer errcode;
	private String errmsg;
	/**
	 * 企业应用id 
	 */
	private Integer agentid;
	/**
	 * 企业应用名称
	 */
	private String name;
	/**
	 * 企业应用方形头像 
	 */
	private String square_logo_url;
	/**
	 * 企业应用圆形头像 
	 */
	private String round_logo_url;
	/**
	 * 企业应用详情 
	 */
	private String description;
	/**
	 * 企业应用可见范围（人员），其中包括userid和关注状态state
	 */
	private AllowUserinfos allow_userinfos;
	/**
	 * 企业应用可见范围（部门） 
	 */
	private AllowPartys allow_partys;
	/**
	 * 企业应用可见范围（标签） 
	 */
	private AllowTags allow_tags;
	/**
	 * 企业应用是否被禁用 
	 */
	private Integer close;
	/**
	 * 企业应用可信域名 
	 */
	private String redirect_domain;
	/**
	  * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报
	  */ 
	private Integer report_location_flag;
	/**
	 * 是否接收用户变更通知。0：不接收；1：接收 
	 */
	private Integer isreportuser;
	/**
	 * 是否上报用户进入应用事件。0：不接收；1：接收 
	 */
	private Integer isreportenter;
	/**
	 * 关联会话url 
	 */
	private String chat_extension_url;
	/**
	 * 应用类型。1：消息型；2：主页型
	 */
	private Integer type;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSquare_logo_url() {
		return square_logo_url;
	}

	public void setSquare_logo_url(String square_logo_url) {
		this.square_logo_url = square_logo_url;
	}

	public String getRound_logo_url() {
		return round_logo_url;
	}

	public void setRound_logo_url(String round_logo_url) {
		this.round_logo_url = round_logo_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AllowUserinfos getAllow_userinfos() {
		return allow_userinfos;
	}

	public void setAllow_userinfos(AllowUserinfos allow_userinfos) {
		this.allow_userinfos = allow_userinfos;
	}

	public AllowPartys getAllow_partys() {
		return allow_partys;
	}

	public void setAllow_partys(AllowPartys allow_partys) {
		this.allow_partys = allow_partys;
	}

	public AllowTags getAllow_tags() {
		return allow_tags;
	}

	public void setAllow_tags(AllowTags allow_tags) {
		this.allow_tags = allow_tags;
	}

	public Integer getClose() {
		return close;
	}

	public void setClose(Integer close) {
		this.close = close;
	}

	public String getRedirect_domain() {
		return redirect_domain;
	}

	public void setRedirect_domain(String redirect_domain) {
		this.redirect_domain = redirect_domain;
	}

	public Integer getReport_location_flag() {
		return report_location_flag;
	}

	public void setReport_location_flag(Integer report_location_flag) {
		this.report_location_flag = report_location_flag;
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

	public String getChat_extension_url() {
		return chat_extension_url;
	}

	public void setChat_extension_url(String chat_extension_url) {
		this.chat_extension_url = chat_extension_url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}

}
