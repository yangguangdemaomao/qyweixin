package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,image消息
 * @author Walker
 *
 */
public class OutImageMsg extends OutBaseMsg {
	
	private Image image;
	/**
	 * 消息类型
	 */
	private String msgtype = "image";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
