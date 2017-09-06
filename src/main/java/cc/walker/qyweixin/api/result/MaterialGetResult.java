package cc.walker.qyweixin.api.result;

import java.io.File;

public class MaterialGetResult {
	
	private Integer errcode;
	private String errmsg;
	private MaterialGetJson json;
	private File file;

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

	public MaterialGetJson getJson() {
		return json;
	}

	public void setJson(MaterialGetJson json) {
		this.json = json;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
