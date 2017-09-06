package cc.walker.qyweixin.api.result;

import java.util.List;

import cc.walker.qyweixin.api.req.Article;

public class MaterialBatchGetResult implements Result {

	private Integer errcode;
	private String errmsg;
	private String type;
	private Media itemlist;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Media getItemlist() {
		return itemlist;
	}

	public void setItemlist(Media itemlist) {
		this.itemlist = itemlist;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}

	public class Media {
		private String media_id;
		private String filename;
		private Integer update_time;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public Integer getUpdate_time() {
			return update_time;
		}

		public void setUpdate_time(Integer update_time) {
			this.update_time = update_time;
		}

	}

	public class Content {
		private List<Article> articles;

		public List<Article> getArticles() {
			return articles;
		}

		public void setArticles(List<Article> articles) {
			this.articles = articles;
		}
	}
}
