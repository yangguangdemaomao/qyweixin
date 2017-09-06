package cc.walker.qyweixin.msg.resp.initiative;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cc.walker.qyweixin.util.JsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestMsg {
	
	@Test
	public void testOutNewsMsg2Str() {
		News news = new News();
		List<Article> list = new ArrayList<Article>();
		Article article1 = new Article("标题", "描述", "http://www.baidu.com", "http://www.baidu.com/a.png");
		list.add(article1);
		news.setArticles(list);
		OutNewsMsg outNewsMsg = new OutNewsMsg();
		outNewsMsg.setNews(news);
		outNewsMsg.setSafe(0);
		outNewsMsg.setTouser("");
    	System.out.println(JsonUtil.toJson(outNewsMsg));
	}
}
