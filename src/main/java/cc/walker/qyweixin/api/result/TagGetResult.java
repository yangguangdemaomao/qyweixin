package cc.walker.qyweixin.api.result;

import java.util.List;

/**
 * 获取标签结果
 * 
 * @author walker
 *
 */
public class TagGetResult implements Result {

	private Integer errcode;
	private String errmsg;
	private List<User> userlist;
	private List<Integer> partylist;

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

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public List<Integer> getPartylist() {
		return partylist;
	}

	public void setPartylist(List<Integer> partylist) {
		this.partylist = partylist;
	}
	
	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}
}
