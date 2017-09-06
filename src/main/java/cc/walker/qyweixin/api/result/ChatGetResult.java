package cc.walker.qyweixin.api.result;

import cc.walker.qyweixin.api.req.ChatCreateParam;

public class ChatGetResult {

	private Integer errcode;
	private String errmsg;
	private ChatCreateParam chat_info;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public ChatCreateParam getChat_info() {
		return chat_info;
	}

	public void setChat_info(ChatCreateParam chat_info) {
		this.chat_info = chat_info;
	}
}
