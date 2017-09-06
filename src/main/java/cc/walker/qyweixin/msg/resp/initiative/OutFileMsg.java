package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,file消息
 * @author walker
 *
 */
public class OutFileMsg extends OutBaseMsg {

	private File file;
	/**
	 * 消息类型
	 */
	private String msgtype = "file";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
