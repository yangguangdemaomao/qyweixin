package cc.walker.qyweixin.token;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import cc.walker.qyweixin.cnst.QyWechatConfig;
import cc.walker.qyweixin.util.StrUtil;

/**
 * 初始化servlet
 * 
 * @author walker
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(InitServlet.class);

	public void init() throws ServletException {
		// 获取web.xml中配置的参数
		String corpid = QyWechatConfig.getCorpid();
		String corpsecret = QyWechatConfig.getCorpsecret();

		log.info("weixin api corpid:{"+corpid+"}");
		log.info("weixin api appsecret:{"+corpsecret+"}");

		// 未配置appid、appsecret时给出提示
		if (StrUtil.notBlank(corpid) && StrUtil.notBlank(corpsecret)) {
			// 启动定时获取access_token的线程
			new Thread(new TokenThread(corpid, corpsecret, 1)).start();
		} else {
			log.info("corpid and appsecret is not config, please check carefully.");
		}
		
		String corpid2 = QyWechatConfig.getCorpid2();
		String corpsecret2 = QyWechatConfig.getCorpsecret2();

		log.info("weixin api corpid2:{"+corpid2+"}");
		log.info("weixin api appsecret2:{"+corpsecret2+"}");
		// 未配置appid、appsecret时给出提示
		if (StrUtil.notBlank(corpid2) && StrUtil.notBlank(corpsecret2)) {
			// 启动定时获取access_token的线程
			new Thread(new TokenThread(corpid2, corpsecret2, 2)).start();
		} else {
			log.info("corpid2 and appsecret2 is not config, please check carefully.");
		}
	}
}