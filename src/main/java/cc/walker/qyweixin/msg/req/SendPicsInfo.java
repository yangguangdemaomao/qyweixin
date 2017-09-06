package cc.walker.qyweixin.msg.req;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SendPicsInfo")  
public class SendPicsInfo {
	
	private Integer Count;
	private List<Item> PicList;

	public Integer getCount() {
		return Count;
	}

	public void setCount(Integer count) {
		Count = count;
	}

	public List<Item> getPicList() {
		return PicList;
	}

	public void setPicList(List<Item> picList) {
		PicList = picList;
	}
}
