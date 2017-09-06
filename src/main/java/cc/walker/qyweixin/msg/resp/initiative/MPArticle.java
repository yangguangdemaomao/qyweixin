package cc.walker.qyweixin.msg.resp.initiative;

public class MPArticle {

	/**
	 * 图文消息的标题，不超过128个字节，超过会自动截断 
	 */
	private String title;
	/**
	 * 图文消息缩略图的media_id, 可以在上传多媒体文件接口中获得。此处thumb_media_id即上传接口返回的media_id 
	 */
    private String thumb_media_id;
    /**
     * 图文消息的作者，不超过64个字节 
     */
    private String author;
    /**
     * 图文消息点击“阅读原文”之后的页面链接 
     */
    private String content_source_url;
    /**
     * 图文消息的内容，支持html标签，不超过666 K个字节 
     */
    private String content;
    /**
     * 图文消息的描述，不超过512个字节，超过会自动截断 
     */
    private Integer digest;
    /**
     * 是否显示封面，1为显示，0为不显示
     */
	private Integer show_cover_pic;
	
	public MPArticle() {
		super();
	}
	
	public MPArticle(String title, String thumb_media_id, String author,
			String content_source_url, String content, Integer digest,
			Integer show_cover_pic) {
		super();
		this.title = title;
		this.thumb_media_id = thumb_media_id;
		this.author = author;
		this.content_source_url = content_source_url;
		this.content = content;
		this.digest = digest;
		this.show_cover_pic = show_cover_pic;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent_source_url() {
		return content_source_url;
	}

	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDigest() {
		return digest;
	}

	public void setDigest(Integer digest) {
		this.digest = digest;
	}

	public Integer getShow_cover_pic() {
		return show_cover_pic;
	}

	public void setShow_cover_pic(Integer show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
}
