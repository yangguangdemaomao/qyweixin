package cc.walker.qyweixin.api;

import javax.jws.soap.InitParam;

import org.junit.Before;
import org.junit.Test;

import cc.walker.qyweixin.api.req.KfSendParam;
import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.cnst.QyWechatConfig;
import cc.walker.qyweixin.token.AccessToken;
import cc.walker.qyweixin.token.AccessTokenApi;
import cc.walker.qyweixin.token.TokenManager;
import cc.walker.qyweixin.util.JsonUtil;

public class TestKfApi {
	
	@Before
	public void init() {
		String corpid = QyWechatConfig.getCorpid();
		String corpsecret = QyWechatConfig.getCorpsecret();
		AccessToken at = AccessTokenApi.getAccessToken(corpid, corpsecret);
		TokenManager.setAt(at);
	}
	
	@Test
	public void getToken() {
		String corpid = QyWechatConfig.getCorpid();
		String corpsecret = QyWechatConfig.getCorpsecret();
		AccessToken at = AccessTokenApi.getAccessToken(corpid, corpsecret);
		System.out.println(at.getAccess_token());
	}
	
	@Test
	public void testListKf() {
		System.out.println(JsonUtil.toJson(KfApi.listKf("")));
	}
	
	@Test
	public void testSendKf() {
		KfSendParam param = new KfSendParam();
		KfSendParam.KfUser sender = param.new KfUser();
		sender.setId("hx-l");
		sender.setType("kf");
		param.setSender(sender);
		KfSendParam.KfUser receiver = param.new KfUser();
		receiver.setId("yq.w");
		receiver.setType("userid");
		param.setReceiver(receiver);
		KfSendParam.Text text = param.new Text("测试客服消息");
		param.setText(text);
		param.setMsgtype("text");
		ApiResult result = KfApi.sendKf(param);
		System.out.println(result.getInt("errcode"));
		System.out.println(result.getStr("errmsg"));
	}
}
