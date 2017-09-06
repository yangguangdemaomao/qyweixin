package cc.walker.qyweixin.api.result;

import java.util.List;

public class ChatSetMuteResult implements Result {
	
	private Integer errcode;
	private String errmsg;
	private List<String> invaliduser;

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

	public List<String> getInvaliduser() {
		return invaliduser;
	}

	public void setInvaliduser(List<String> invaliduser) {
		this.invaliduser = invaliduser;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}

}
