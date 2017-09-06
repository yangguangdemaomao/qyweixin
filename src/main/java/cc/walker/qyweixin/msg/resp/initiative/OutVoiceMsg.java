package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,voice消息
 * @author walker
 * 
 */
public class OutVoiceMsg extends OutBaseMsg {

	private Voice voice;
	/**
	 * 消息类型
	 */
	private String msgtype="voice";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}
