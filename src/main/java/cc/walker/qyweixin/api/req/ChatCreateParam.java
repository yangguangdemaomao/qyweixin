package cc.walker.qyweixin.api.req;

import java.util.List;

/**
 * 
 * @author walker
 *
 */
public class ChatCreateParam {
	
	/**
	 * 会话id。字符串类型，最长32个字符。只允许字符0-9及字母a-zA-Z,如果值内容为64bit无符号整型：
	 * 要求值范围在[1, 2^63)之间，
	 * [2^63, 2^64)为系统分配会话id区间 
	 */
	private String chatid;
	/**
	 * 会话标题 
	 */
	private String name;
	/**
	 * 管理员userid，必须是该会话userlist的成员之一 
	 */
	private String owner;
	/**
	 * 会话成员列表，成员用userid来标识。会话成员必须在3人或以上，1000人以下
	 */
	private List<String> userlist;

	public ChatCreateParam(String chatid, String name, String owner,
			List<String> userlist) {
		super();
		this.chatid = chatid;
		this.name = name;
		this.owner = owner;
		this.userlist = userlist;
	}

	public ChatCreateParam() {
		super();
	}

	public String getChatid() {
		return chatid;
	}

	public void setChatid(String chatid) {
		this.chatid = chatid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<String> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<String> userlist) {
		this.userlist = userlist;
	}
}
