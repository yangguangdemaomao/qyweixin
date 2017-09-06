package cc.walker.qyweixin.api.result;

import java.io.File;

/**
 * 获取临时素材返回
 * 
 * @author walker
 *
 */
public class MediaGetResult implements Result {

	private Integer errcode;
	private String errmsg;
	//获取临时素材文件
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}

}
