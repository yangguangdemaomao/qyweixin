package cc.walker.qyweixin.api;

import org.junit.Before;
import org.junit.Test;

import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.msg.resp.initiative.OutTextMsg;
import cc.walker.qyweixin.msg.resp.initiative.Text;
import cc.walker.qyweixin.token.AccessToken;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.JsonUtil;

public class TestMsgApi {
	
	@Before
	public void init() {
		AccessToken accessToken = new AccessToken();
		accessToken.setAccess_token("fES0ullSigUN2oqf3gIApfyZVcXbVKjVv1jpOeG4YMMTHKAMjHwaxz4pks5w2o54");
		TokenManager.setAt(accessToken);
	}

	@Test
	public void testSendTextMsg() {
		OutTextMsg textMessage = new OutTextMsg();
		textMessage.setAgentid(12);
		textMessage.setMsgtype("text");
		textMessage.setSafe(0);
		textMessage.setTouser("yq.w|hx-l");
		textMessage.setText(new Text("您好"));
		ApiResult result = MsgApi.sendMsg(textMessage);
		System.out.println(JsonUtil.toJson(result));
	}
	
	@Test
	public void testSendImageMsg() {
		
	}
}
