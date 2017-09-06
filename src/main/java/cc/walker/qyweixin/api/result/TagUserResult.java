package cc.walker.qyweixin.api.result;

import java.util.List;

/**
 * add tag users return
 * 
 * @author walker
 * @date 2016-09-13
 */
public class TagUserResult implements Result {

	private Integer errcode;
	private String errmsg;
	private String invalidlist;
	private List<Integer> invalidparty;
	
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

	public String getInvalidlist() {
		return invalidlist;
	}

	public void setInvalidlist(String invalidlist) {
		this.invalidlist = invalidlist;
	}

	public List<Integer> getInvalidparty() {
		return invalidparty;
	}

	public void setInvalidparty(List<Integer> invalidparty) {
		this.invalidparty = invalidparty;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0 && invalidparty == null;
	}

}
