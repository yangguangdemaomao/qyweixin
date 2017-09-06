package cc.walker.qyweixin.token;

import java.util.Date;

/**
 * access_token基础类
 * 
 * @author walker
 * @date 2016-09-06
 */
public class AccessToken {

	/**
	 * 获取到的凭证。长度为64至512个字节
	 */
	private String access_token;
	/**
	 *  	凭证的有效时间（秒）
	 */
	private Integer expires_in;
	/**
	 * 获取token返回的错误码
	 */
	private Integer errcode;
	/**
	 * 获取token返回的错误消息
	 */
	private String errmsg;
	/**
	 * 获取token的时间
	 */
	private Date gettime;
	
	public boolean isValid() {
		return errcode == 0;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Date getGettime() {
		return gettime;
	}

	public void setGettime(Date gettime) {
		this.gettime = gettime;
	}
}
