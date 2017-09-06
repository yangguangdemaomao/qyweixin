package cc.walker.qyweixin.api.req;

public class KfSendParam {

	private KfUser receiver;
	private KfUser sender;
	private String msgtype;
	private Text text;
	private KfMedia image;
	private KfMedia file;
	private KfMedia voice;

	public KfMedia getImage() {
		return image;
	}

	public void setImage(KfMedia image) {
		this.image = image;
	}

	public KfMedia getFile() {
		return file;
	}

	public void setFile(KfMedia file) {
		this.file = file;
	}

	public KfMedia getVoice() {
		return voice;
	}

	public void setVoice(KfMedia voice) {
		this.voice = voice;
	}

	public KfUser getReceiver() {
		return receiver;
	}

	public void setReceiver(KfUser receiver) {
		this.receiver = receiver;
	}

	public KfUser getSender() {
		return sender;
	}

	public void setSender(KfUser sender) {
		this.sender = sender;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public class KfUser {
		private String type;
		private String id;

		public KfUser() {
			super();
		}

		public KfUser(String type, String id) {
			super();
			this.type = type;
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

	public class Text {
		private String content;

		public Text() {
			super();
		}

		public Text(String content) {
			super();
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public class KfMedia {
		private String media_id;

		public KfMedia() {
			super();
		}

		public KfMedia(String media_id) {
			super();
			this.media_id = media_id;
		}

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

	}
}
