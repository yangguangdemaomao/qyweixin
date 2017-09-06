package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,video消息
 * @author Walker
 *
 */
public class OutVideoMsg extends OutBaseMsg {
	
	private Video video;
	/**
	 * 消息类型
	 */
	private String msgtype = "video";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
