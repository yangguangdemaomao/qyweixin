package cc.walker.qyweixin.msg.resp.passive;

/**
 * 被动响应,voice消息
 * @author walker
 *
 */
public class OutVoiceXmlMsg extends OutBaseXmlMsg {

	private VoiceXml Voice;

	public VoiceXml getVoice() {
		return Voice;
	}

	public void setVoice(VoiceXml voice) {
		Voice = voice;
	}
}
