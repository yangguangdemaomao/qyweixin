package cc.walker.qyweixin.api.req;

/**
 * 批量获取素材传入参数
 * 
 * @author walker
 *
 */
public class MaterialBatchGetParam {

	/**
	 * 素材类型，可以为图文(mpnews)、图片（image）、音频（voice）、视频（video）、文件（file）
	 */
	private String type;
	/**
	 * 从该类型素材的该偏移位置开始返回，0表示从第一个素材 返回
	 */
	private Integer offset;
	/**
	 * 返回素材的数量，取值在1到50之间
	 */
	private Integer count;

	public MaterialBatchGetParam() {
		super();
	}

	public MaterialBatchGetParam(String type, Integer offset, Integer count) {
		super();
		this.type = type;
		this.offset = offset;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
