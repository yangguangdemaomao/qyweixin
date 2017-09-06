package cc.walker.qyweixin.msg;

import cc.walker.qyweixin.msg.req.BatchJob;
import cc.walker.qyweixin.msg.req.InMsg;
import cc.walker.qyweixin.util.XmlUtil;

/**
 * 微信消息转换器
 * @author walker
 * @2016-09-07
 */
public class MsgParser {

	public static InMsg doParse(String xml) {
		return XmlUtil.fromXml(xml, InMsg.class);
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		String xml = "<xml><ToUserName><![CDATA[wx8ea6ec2bc994af5c]]></ToUserName>" +
			"<FromUserName><![CDATA[hx-l]]></FromUserName>" +
			"<CreateTime>1496296153</CreateTime>" +
			"<MsgType><![CDATA[text]]></MsgType>" +
			"<Content><![CDATA[你好]]></Content>" +
			"<MsgId>5369305476219049608</MsgId>" +
			"<AgentID>19</AgentID>" +
			"</xml>";
			InMsg inMsg = doParse(xml);
			System.out.println(inMsg.getContent());
	}
}
