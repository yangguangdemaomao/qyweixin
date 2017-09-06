package cc.walker.qyweixin.msg.resp.passive;

public class VoiceXml {

	/**
	 * 语音文件id，可以调用上传媒体文件接口获取
	 */
	private String MediaId;

	public VoiceXml() {
		super();
	}

	public VoiceXml(String mediaId) {
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
