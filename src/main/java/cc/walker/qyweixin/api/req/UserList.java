package cc.walker.qyweixin.api.req;

import java.util.List;

/**
 * 批量删除用户
 * 
 * @author walker
 * @date 2016-09-13
 */
public class UserList {

	private List<String> useridlist;

	public UserList(List<String> useridlist) {
		super();
		this.useridlist = useridlist;
	}

	public UserList() {
		super();
	}

	public List<String> getUseridlist() {
		return useridlist;
	}

	public void setUseridlist(List<String> useridlist) {
		this.useridlist = useridlist;
	}
}
