package cc.walker.qyweixin.api.req;

/**
 * 异步接口请求参数
 * 
 * @author walker
 * @date 2016-09-14
 */
public class AsyncReqParam {
	
	/**
	 * 上传的csv文件的media_id 
	 */
	private String media_id;
	/**
	 * 回调信息。如填写该项则任务完成后，通过callback推送事件给企业。
	 * 具体请参考应用回调模式中的相应选项 
	 */
	private Callback callback;

	public AsyncReqParam() {
		super();
	}

	public AsyncReqParam(String media_id, String url, String token, String encodingaeskey) {
		super();
		this.media_id = media_id;
		this.callback = new Callback(url, token, encodingaeskey);
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public Callback getCallback() {
		return callback;
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	private class Callback {
		/**
		 *  企业应用接收企业号推送请求的访问协议和地址，支持http或https协议
		 */
		private String url;
		/**
		 *  用于生成签名 
		 */
		private String token;
		/**
		 * 用于消息体的加密，是AES密钥的Base64编码 
		 */
		private String encodingaeskey;

		public Callback() {
			super();
		}

		public Callback(String url, String token, String encodingaeskey) {
			super();
			this.url = url;
			this.token = token;
			this.encodingaeskey = encodingaeskey;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getEncodingaeskey() {
			return encodingaeskey;
		}

		public void setEncodingaeskey(String encodingaeskey) {
			this.encodingaeskey = encodingaeskey;
		}
	}
}
