package cc.walker.qyweixin.api.req;

public class UserAttr {

	private String name;
	private String value;

	public UserAttr(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public UserAttr() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
