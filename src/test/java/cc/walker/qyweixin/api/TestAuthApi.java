package cc.walker.qyweixin.api;

import org.junit.Test;

import cc.walker.qyweixin.api.result.ApiResult;
import cc.walker.qyweixin.token.AccessToken;
import cc.walker.qyweixin.token.TokenManager;

public class TestAuthApi {

	@Test
	public void testConvertUserId2OpenId() {
		AccessToken accessToken = new AccessToken();
		accessToken.setAccess_token("uzLpPnucsmbRQwCS_jLF6hLRgrttI_jOb0aWhGMKCWbRCmZfgNaSDfs-q2kQwV3u");
		TokenManager.setAt(accessToken);
		ApiResult result = AuthApi.convertUserId2OpenId("yq.w");
		System.out.println(result.getStr("openid"));
	}
	
	@Test
	public void testLogin() {
		AccessToken accessToken = new AccessToken();
		accessToken.setAccess_token("bgGylvSv2b1MKPJnEbOzI8SrN-DatoFuYkgmk9b75BNvPDHp2_te7i1ejt5R9_WJ");
		TokenManager.setAt(accessToken);
		ApiResult result = AuthApi.getUserInfo("bgGylvSv2b1MKPJnEbOzI8SrN-DatoFuYkgmk9b75BNvPDHp2_te7i1ejt5R9_WJ", 3);
		System.out.println(result);
	}

}
