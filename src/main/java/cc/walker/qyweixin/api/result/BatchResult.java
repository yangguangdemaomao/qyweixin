package cc.walker.qyweixin.api.result;

public class BatchResult implements Result {
	/**
	 * 操作类型（按位或）：1 新建部门 ，2 更改部门名称， 4 移动部门， 8 修改部门排序 
	 */
	private Integer action;
	/**
	 * 部门ID
	 */
	private Integer partyid;
	/**
	 *  	成员UserID。对应管理端的帐号 
	 */
	private String userid;
	private Integer errcode;
	private String errmsg;
	
	
	
	public Integer getAction() {
		return action;
	}



	public void setAction(Integer action) {
		this.action = action;
	}



	public Integer getPartyid() {
		return partyid;
	}



	public void setPartyid(Integer partyid) {
		this.partyid = partyid;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



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



	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}
}
