package cc.walker.qyweixin.msg.resp.passive;

public class ImageXml {

	/**
	 * 图片文件id，可以调用上传媒体文件接口获取
	 */
	private String MediaId;

	public ImageXml() {
		super();
	}

	public ImageXml(String mediaId) {
		super();
		MediaId = mediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
