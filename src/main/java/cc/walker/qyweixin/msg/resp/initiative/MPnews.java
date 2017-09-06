package cc.walker.qyweixin.msg.resp.initiative;

import java.util.List;

/**
 * 图文消息，一个图文消息支持1到8个图文 
 * @author walker
 *
 */
public class MPnews {

	private List<MPArticle> articles;
	
	public MPnews() {
		super();
	}

	public MPnews(List<MPArticle> articles) {
		super();
		this.articles = articles;
	}


	public List<MPArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<MPArticle> articles) {
		this.articles = articles;
	}
}
