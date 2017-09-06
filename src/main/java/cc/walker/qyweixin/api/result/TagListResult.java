package cc.walker.qyweixin.api.result;

import java.util.List;

/**
 * 获取标签列表返回
 * 
 * @author walker
 * @date 2016-09-14
 */
public class TagListResult implements Result {

	private Integer errcode;
	private String errmsg;
	private List<Tag> taglist;

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

	public List<Tag> getTaglist() {
		return taglist;
	}

	public void setTaglist(List<Tag> taglist) {
		this.taglist = taglist;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}
}
