package cc.walker.qyweixin.api.req;

public class ChatSendParam {

	private Receiver receiver;
	private String sender;
	private String msgtype;
	private Text text;
	private Image image;
	private File file;
	private Voice voice;
	private Link link;

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public class Receiver {
		private String type;
		private String id;

		public Receiver() {
			super();
		}

		public Receiver(String type, String id) {
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

	public class Image {
		private String media_id;

		public Image() {
			super();
		}

		public Image(String media_id) {
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

	public class File {
		private String media_id;

		public File() {
			super();
		}

		public File(String media_id) {
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

	public class Voice {
		private String media_id;

		public Voice() {
			super();
		}

		public Voice(String media_id) {
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

	public class Link {
		private String title;
		private String description;
		private String url;
		private String thumb_media_id;

		public Link() {
			super();
		}

		public Link(String title, String description, String url,
				String thumb_media_id) {
			super();
			this.title = title;
			this.description = description;
			this.url = url;
			this.thumb_media_id = thumb_media_id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getThumb_media_id() {
			return thumb_media_id;
		}

		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}
	}
}
