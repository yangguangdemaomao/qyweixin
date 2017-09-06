package cc.walker.qyweixin.msg.resp.initiative;

/**
 * 主动发送,news消息
 * @author walker
 *
 */
public class OutNewsMsg extends OutBaseMsg {

	private News news;
	/**
	 * 消息类型
	 */
	private String msgtype = "news";
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
