package cc.walker.qyweixin.api;

import org.junit.Test;

import cc.walker.qyweixin.token.AccessToken;
import cc.walker.qyweixin.token.AccessTokenApi;

public class TestAccessTokenApi {

	@Test
	public void testGetAccessToken() {
		String corpid = "";
		String corpsecret = "";
		AccessToken accessToken = AccessTokenApi.getAccessToken(corpid, corpsecret);
		System.out.println(accessToken.getAccess_token());
	}
}
