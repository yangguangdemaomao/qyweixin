package cc.walker.qyweixin.token;


/**
 * access_token的存储管理类
 * 项目运行的时候初始化该类，获取access_token
 * @author walker
 * @date 2016-09-06
 */
public class TokenManager {
	
	private static AccessToken at;
	private static AccessToken at2;

	public static void setAt(AccessToken at) {
		TokenManager.at = at;
	}

	public static String getToken() {
		return at.getAccess_token();
	}
	
	public static Integer getExpiresIn() {
		return at.getExpires_in();
	}
	
	public static void setAt2(AccessToken at2) {
		TokenManager.at2 = at2;
	}

	public static String getToken2() {
		return at2.getAccess_token();
	}
	
	public static Integer getExpiresIn2() {
		return at2.getExpires_in();
	}

}
