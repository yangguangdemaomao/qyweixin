package cc.walker.qyweixin.api.req;

import java.util.List;

/**
 * 添加永久素材传入参数
 * @author walker
 *
 */
public class Mpnews {
	
	private List<Article> articles;

	public Mpnews() {
		super();
	}

	public Mpnews(List<Article> articles) {
		super();
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
