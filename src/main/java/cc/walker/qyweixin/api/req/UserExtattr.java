package cc.walker.qyweixin.api.req;

import java.util.List;

public class UserExtattr {

	private List<UserAttr> attrs;

	public UserExtattr(List<UserAttr> attrs) {
		super();
		this.attrs = attrs;
	}

	public UserExtattr() {
		super();
	}

	public List<UserAttr> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<UserAttr> attrs) {
		this.attrs = attrs;
	}
}
