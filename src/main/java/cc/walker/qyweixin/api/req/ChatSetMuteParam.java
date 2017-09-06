package cc.walker.qyweixin.api.req;

import java.util.List;

public class ChatSetMuteParam {
	
	/**
	 * 成员新消息免打扰参数，数组，最大支持10000个成员 
	 */
	private List<MuteUser> user_mute_list;

	public List<MuteUser> getUser_mute_list() {
		return user_mute_list;
	}

	public void setUser_mute_list(List<MuteUser> user_mute_list) {
		this.user_mute_list = user_mute_list;
	}

	public class MuteUser {
		/**
		 * 成员UserID
		 */
		private String userid;
		/**
		 * 免打扰状态，0关闭，1打开,默认为0。当打开时所有消息不提醒；当关闭时，以成员对会话的设置为准。
		 */
		private Integer status;

		public MuteUser() {
			super();
		}

		public MuteUser(String userid, Integer status) {
			super();
			this.userid = userid;
			this.status = status;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}
	}
}
