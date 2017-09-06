package cc.walker.qyweixin.msg.resp.passive;

import java.io.Serializable;

/**
 * 被动回复消息基础父类
 * 
 * @author walker
 * @date 2016-09-05
 */
public class OutBaseXmlMsg implements Serializable {
	/**
	 * 成员UserID
	 */
	private String ToUserName;
	/**
	 * 企业号CorpID
	 */
	private String FromUserName;
	/**
	 * 消息创建时间（整型）
	 */
	private String CreateTime;
	/**
	 * 消息类型 text,image,voice,video,news,
	 */
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
