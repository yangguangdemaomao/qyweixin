package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,text消息
 * @author Walker
 *
 */
public class OutTextMsg extends OutBaseMsg {

	private Text text;
	/**
	 * 消息类型
	 */
	private String msgtype = "text";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
}
