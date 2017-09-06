package cc.walker.qyweixin.msg.kf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("xml")
public class KfMsg {

	private String AgentType;
	private String ToUserName;
	private Integer ItemCount;
	private String PackageId;

	@XStreamImplicit(itemFieldName="Item")
	private List<Item> items;
	
	public String getAgentType() {
		return AgentType;
	}

	public void setAgentType(String agentType) {
		AgentType = agentType;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public Integer getItemCount() {
		return ItemCount;
	}

	public void setItemCount(Integer itemCount) {
		ItemCount = itemCount;
	}

	public String getPackageId() {
		return PackageId;
	}

	public void setPackageId(String packageId) {
		PackageId = packageId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public class Item {
		private String FromUserName;
		private String CreateTime;
		private String MsgType;
		private String MsgId;
		// 文本消息
		private String Content;
		//图片消息
		private String PicUrl;
		private String MediaId;
		//link消息
		private String Title;
		private String Description;
		private String Url;
		//位置消息
		private String Location_X;
		private String Location_Y;
		private String Scale;
		private String Label;
		private String Event;
		private Receiver Receiver;
		public Receiver getReceiver() {
			return Receiver;
		}
		public void setReceiver(Receiver receiver) {
			Receiver = receiver;
		}
		public String getFromUserName() {
			return FromUserName;
		}
		public void setFromUserName(String fromUserName) {
			FromUserName = fromUserName;
		}
		public String getCreateTime() {
			return CreateTime;
		}
		public void setCreateTime(String createTime) {
			CreateTime = createTime;
		}
		public String getMsgType() {
			return MsgType;
		}
		public void setMsgType(String msgType) {
			MsgType = msgType;
		}
		public String getMsgId() {
			return MsgId;
		}
		public void setMsgId(String msgId) {
			MsgId = msgId;
		}
		public String getContent() {
			return Content;
		}
		public void setContent(String content) {
			Content = content;
		}
		public String getPicUrl() {
			return PicUrl;
		}
		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}
		public String getMediaId() {
			return MediaId;
		}
		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
		public String getLocation_X() {
			return Location_X;
		}
		public void setLocation_X(String location_X) {
			Location_X = location_X;
		}
		public String getLocation_Y() {
			return Location_Y;
		}
		public void setLocation_Y(String location_Y) {
			Location_Y = location_Y;
		}
		public String getScale() {
			return Scale;
		}
		public void setScale(String scale) {
			Scale = scale;
		}
		public String getLabel() {
			return Label;
		}
		public void setLabel(String label) {
			Label = label;
		}
		public String getEvent() {
			return Event;
		}
		public void setEvent(String event) {
			Event = event;
		}
	}

	public class Receiver {
		private String Type;
		private String Id;

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

	}
}
