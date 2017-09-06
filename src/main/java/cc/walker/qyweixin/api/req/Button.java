package cc.walker.qyweixin.api.req;

import java.util.List;

public class Button {

	private String type;
	private String name;
	private String key;
	private List<SubButton> sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<SubButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<SubButton> sub_button) {
		this.sub_button = sub_button;
	}
}
