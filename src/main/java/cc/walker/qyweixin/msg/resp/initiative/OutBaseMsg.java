package cc.walker.qyweixin.msg.resp.initiative;

import java.io.Serializable;

import cc.walker.qyweixin.cnst.QyWechatConfig;

/**
 * 主动发送消息,基础类
 * @author walker
 *
 */
@SuppressWarnings("serial")
public class OutBaseMsg implements Serializable {
	
	/**
	 * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。
	 * 特殊情况：指定为@all，则向关注该企业应用的全部成员发送 
	 */
	private String touser;
	/**
	 * 部门ID列表，多个接收者用‘|’分隔，最多支持100个。
	 * 当touser为@all时忽略本参数 
	 */
	private String toparty;
	/**
	 * 标签ID列表，多个接收者用‘|’分隔，最多支持100个。
	 * 当touser为@all时忽略本参数 
	 */
	private String totag;
	/**
	 * 企业应用的id，整型。可在应用的设置页面查看 
	 */
	private Integer agentid = Integer.parseInt(QyWechatConfig.getAppid());
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0 
	 */
	private Integer safe = 0;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getToparty() {
		return toparty;
	}

	public void setToparty(String toparty) {
		this.toparty = toparty;
	}

	public String getTotag() {
		return totag;
	}

	public void setTotag(String totag) {
		this.totag = totag;
	}
	
	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public Integer getSafe() {
		return safe;
	}

	public void setSafe(Integer safe) {
		this.safe = safe;
	}
}
