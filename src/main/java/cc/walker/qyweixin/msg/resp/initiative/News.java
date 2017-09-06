package cc.walker.qyweixin.msg.resp.initiative;

import java.util.List;

/**
 * 图文消息，一个图文消息支持1到8条图文
 * 
 * @author walker
 *
 */
public class News {

	private List<Article> articles;

	public News() {
		super();
	}

	public News(List<Article> articles) {
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
