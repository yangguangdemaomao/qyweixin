package cc.walker.qyweixin.api.result;

import cc.walker.qyweixin.api.req.Mpnews;

public class MaterialGetJson {

	private String type;
	private Mpnews mpnews;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Mpnews getMpnews() {
		return mpnews;
	}

	public void setMpnews(Mpnews mpnews) {
		this.mpnews = mpnews;
	}
}
