package cc.walker.qyweixin.msg.resp.passive;

/**
 * 被动相应,video消息
 * 
 * @author Administrator
 *
 */
public class VideoXml {

	/**
	 * 视频文件id，可以调用上传媒体文件接口获取
	 */
	private String MediaId;
	/**
	 * 视频消息的标题
	 */
	private String Title;
	/**
	 * 视频消息的描述
	 */
	private String Description;

	public VideoXml(String mediaId, String title, String description) {
		super();
		MediaId = mediaId;
		Title = title;
		Description = description;
	}

	public VideoXml() {
		super();
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
