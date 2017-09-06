package cc.walker.qyweixin.msg.resp.passive;

/**
 * 被动响应,text消息
 * @author walker
 *
 */
public class OutTextXmlMsg extends OutBaseXmlMsg {

	/**
	 * 文本消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
