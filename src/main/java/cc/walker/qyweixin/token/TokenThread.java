package cc.walker.qyweixin.token;

import org.apache.log4j.Logger;

/**
 * 定时获取微信access_token的线程 每7000秒刷新一次
 */
public class TokenThread implements Runnable {
	private static Logger log = Logger.getLogger(TokenThread.class);
	// 第三方用户唯一凭证
	private String corpid = "";
	// 第三方用户唯一凭证密钥
	private String corpsecret = "";
	private int index = 1;
	
	public TokenThread(String corpid, String corpsecret, int index) {
		super();
		this.corpid = corpid;
		this.corpsecret = corpsecret;
		this.index = index;
	}

	public void run() {
		while (true) {
			try {
				AccessToken accessToken = AccessTokenApi.getAccessToken(corpid, corpsecret, 3);
				if (null != accessToken) {
					if (index == 1) {
						TokenManager.setAt(accessToken);
					}
					else {
						TokenManager.setAt2(accessToken);
					}
					log.info("获取access_token成功，有效时长{"+ accessToken.getExpires_in() + "}秒 token:{"+ accessToken.getAccess_token() + "}");
					// 休眠7000秒
					Thread.sleep((accessToken.getExpires_in() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error(e1);
					break;
				}
				log.error(e);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
