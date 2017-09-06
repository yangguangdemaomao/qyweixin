package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,mpnews消息
 * @author walker
 *
 */
public class OutMPNewsMsg extends OutBaseMsg {

	/**
	 * 图文消息，一个图文消息支持1到8个图文 
	 */
	private MPnews mpnews;
	/**
	 * 消息类型
	 */
	private String msgtype = "mpnews";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MPnews getMpnews() {
		return mpnews;
	}

	public void setMpnews(MPnews mpnews) {
		this.mpnews = mpnews;
	}
}
