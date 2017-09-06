package cc.walker.qyweixin.api.req;

/**
 * 修改永久图文素材 传入参数
 * @author walker
 *
 */
public class MpnewsUpdate {

	private String media_id;
	private Mpnews mpnews;

	public MpnewsUpdate() {
		super();
	}

	public MpnewsUpdate(String media_id, Mpnews mpnews) {
		super();
		this.media_id = media_id;
		this.mpnews = mpnews;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public Mpnews getMpnews() {
		return mpnews;
	}

	public void setMpnews(Mpnews mpnews) {
		this.mpnews = mpnews;
	}
}
