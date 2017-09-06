package cc.walker.qyweixin.msg.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class Item {
	
	private String PicMd5Sum;

	public String getPicMd5Sum() {
		return PicMd5Sum;
	}

	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
}
