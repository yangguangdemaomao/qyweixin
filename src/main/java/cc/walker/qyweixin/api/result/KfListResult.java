package cc.walker.qyweixin.api.result;

import java.util.List;

public class KfListResult implements Result {

	private Integer errcode;
	private String errmsg;
	private KfInfo internal;
	private KfInfo external;

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

	public KfInfo getInternal() {
		return internal;
	}

	public void setInternal(KfInfo internal) {
		this.internal = internal;
	}

	public KfInfo getExternal() {
		return external;
	}

	public void setExternal(KfInfo external) {
		this.external = external;
	}

	@Override
	public boolean isSucceed() {
		return false;
	}

	public class KfInfo {
		private List<String> user;
		private List<Integer> party;
		private List<Integer> tag;

		public List<String> getUser() {
			return user;
		}

		public void setUser(List<String> user) {
			this.user = user;
		}

		public List<Integer> getParty() {
			return party;
		}

		public void setParty(List<Integer> party) {
			this.party = party;
		}

		public List<Integer> getTag() {
			return tag;
		}

		public void setTag(List<Integer> tag) {
			this.tag = tag;
		}
	}

}
