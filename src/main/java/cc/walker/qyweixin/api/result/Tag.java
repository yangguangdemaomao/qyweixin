package cc.walker.qyweixin.api.result;

/**
 * 标签实体类
 * 
 * @author walker
 * @date 2016-09-13
 */
public class Tag {

	/**
	 * 标签名称，长度限制为32个字（汉字或英文字母），标签名不可与其他标签重名。
	 */
	private String tagname;
	/**
	 * 标签id，整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增
	 */
	private Integer tagid;

	public Tag() {
		super();
	}

	public Tag(String tagname, Integer tagid) {
		super();
		this.tagname = tagname;
		this.tagid = tagid;
	}

	public Tag(String tagname) {
		super();
		this.tagname = tagname;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}
}
