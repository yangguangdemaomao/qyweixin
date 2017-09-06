package cc.walker.qyweixin.api.req;

import java.util.List;

/**
 * 增加成员标签输入参数
 * 
 * @author walker
 * @date 2016-09-13
 */
public class TagUsers {
	
	/**
	 * 标签ID
	 */
	private Integer tagid;
	/**
	 * 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
	 */
	private List<String> userlist;
	/**
	 * 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
	 */
	private List<Integer> partylist;

	public TagUsers(Integer tagid, List<String> userlist,
			List<Integer> partylist) {
		super();
		this.tagid = tagid;
		this.userlist = userlist;
		this.partylist = partylist;
	}

	public TagUsers() {
		super();
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public List<String> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<String> userlist) {
		this.userlist = userlist;
	}

	public List<Integer> getPartylist() {
		return partylist;
	}

	public void setPartylist(List<Integer> partylist) {
		this.partylist = partylist;
	}

}
