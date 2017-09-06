package cc.walker.qyweixin.api.req;

/**
 * 清除会话未读状态请求参数
 * 
 * @author walker
 *
 */
public class ChatClearNotifyParam {

	/**
	 * 会话所有者的userid 
	 */
	private String op_user;
	/**
	 * 会话
	 */
	private Chat chat;

	public ChatClearNotifyParam(String op_user, String type, String id) {
		super();
		Chat chat = new Chat();
		chat.setId(id);
		chat.setType(type);
		this.op_user = op_user;
		this.chat = chat;
	}

	public ChatClearNotifyParam() {
		super();
	}

	public String getOp_user() {
		return op_user;
	}

	public void setOp_user(String op_user) {
		this.op_user = op_user;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	class Chat {
		/**
		 * 会话类型：single|group，分别表示：群聊|单聊 
		 */
		private String type;
		/**
		 * 会话值，为userid|chatid，分别表示：成员id|会话id 
		 */
		private String id;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
