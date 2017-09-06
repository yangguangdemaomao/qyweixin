package cc.walker.qyweixin.api.req;

/**
 * 退出会话请求参数
 * @author walker
 *
 */
public class ChatQuitParam {
	
	/**
	 * 会话id 
	 */
	private String chatid;
	/**
	 * 操作人userid
	 */
	private String op_user;

	public String getChatid() {
		return chatid;
	}

	public void setChatid(String chatid) {
		this.chatid = chatid;
	}

	public String getOp_user() {
		return op_user;
	}

	public void setOp_user(String op_user) {
		this.op_user = op_user;
	}

}
