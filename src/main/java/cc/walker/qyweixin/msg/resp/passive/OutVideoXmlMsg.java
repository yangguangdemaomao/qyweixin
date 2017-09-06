package cc.walker.qyweixin.msg.resp.passive;

/**
 * 被动响应,video消息
 * @author walker
 *
 */
public class OutVideoXmlMsg extends OutBaseXmlMsg {

	private VideoXml Video;

	public VideoXml getVideo() {
		return Video;
	}

	public void setVideo(VideoXml video) {
		Video = video;
	}

}
