package cc.walker.qyweixin.api.result;

import java.util.List;

/**
 * 获取部门成员返回
 * 
 * @author walker
 *
 */
public class UserListResult implements Result {

	private Integer errcode;
	private String errmsg;
	private List<User> userlist;

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

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}
}
