package cc.walker.qyweixin.api.req;

/**
 * 修改会话信息请求参数
 * @author walker
 *
 */
public class ChatUpdateParam {

	/**
	 * 会话id
	 */
	private String chatid;
	/**
	 * 操作人userid 
	 */
	private String op_user;
	/**
	 * 会话标题 
	 */
	private String name;
	/**
	 * 管理员userid，必须是该会话userlist的成员之一 
	 */
	private String owner;
	/**
	 * 会话新增成员列表，成员用userid来标识 
	 */
	private String add_user_list;
	/**
	 * 会话退出成员列表，成员用userid来标识 
	 */
	private String del_user_list;

	public ChatUpdateParam() {
		super();
	}

	public ChatUpdateParam(String chatid, String op_user, String name,
			String owner, String add_user_list, String del_user_list) {
		super();
		this.chatid = chatid;
		this.op_user = op_user;
		this.name = name;
		this.owner = owner;
		this.add_user_list = add_user_list;
		this.del_user_list = del_user_list;
	}

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

	public String getAdd_user_list() {
		return add_user_list;
	}

	public void setAdd_user_list(String add_user_list) {
		this.add_user_list = add_user_list;
	}

	public String getDel_user_list() {
		return del_user_list;
	}

	public void setDel_user_list(String del_user_list) {
		this.del_user_list = del_user_list;
	}
}
