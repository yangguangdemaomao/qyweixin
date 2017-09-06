package cc.walker.qyweixin.msg.resp.initiative;

public class Video {

	private String media_id;
	private String title;
	private String description;
	
	public Video() {
		super();
	}

	public Video(String media_id, String title, String description) {
		super();
		this.media_id = media_id;
		this.title = title;
		this.description = description;
	}


	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
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

}
