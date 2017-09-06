package cc.walker.qyweixin.msg.resp.passive;

import java.io.Serializable;

/**
 * 企业收到普通消息、成员关注事件、菜单click事件、成员进入应用事件后，可以被动响应消息。
 * 企业响应的消息同样应该经过加密，并带上msg_signature、timestamp、nonce及密文，
 * 其中timestamp、nonce由企业指定，msg_signature、密文经特定算法生成，具体算法参见附录。
 * 
 * @author walker
 * @date 2016-09-02
 * 
 */
public class OutXmlMsg implements Serializable {

	private String Encrypt;
	private String MsgSignature;
	private String TimeStamp;
	private String Nonce;

	public String getEncrypt() {
		return Encrypt;
	}

	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}

	public String getMsgSignature() {
		return MsgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		MsgSignature = msgSignature;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getNonce() {
		return Nonce;
	}

	public void setNonce(String nonce) {
		Nonce = nonce;
	}

}
