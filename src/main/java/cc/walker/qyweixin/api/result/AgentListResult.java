package cc.walker.qyweixin.api.result;

import java.util.List;

public class AgentListResult implements Result {
	
	private Integer errcode;
	private String errmsg;
	private List<Agent> agentlist;

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

	public List<Agent> getAgentlist() {
		return agentlist;
	}

	public void setAgentlist(List<Agent> agentlist) {
		this.agentlist = agentlist;
	}
	
	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}
}
