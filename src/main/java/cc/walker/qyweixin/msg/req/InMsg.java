package cc.walker.qyweixin.msg.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class InMsg {

	/**
	 * 企业号CorpID
	 */
	private String ToUserName;

	/**
	 * 成员UserID
	 */
	private String FromUserName;

	/**
	 * 消息创建时间（整型）
	 */
	private Long CreateTime;

	/**
	 * 消息类型 text image voice video shortvideo location link
	 */
	private String MsgType;

	/**
	 * 企业应用的id，整型。可在应用的设置页面查看
	 */
	private String AgentID;

	/**
	 * 图片链接
	 */
	private String PicUrl;

	/**
	 * 图片媒体文件id，可以调用获取媒体文件接口拉取数据
	 */
	private String MediaId;
	
	private String ThumbMediaId;

	/**
	 * 消息id，64位整型
	 */
	private Long MsgId;

	/**
	 * 标题
	 */
	private String Title;

	/**
	 * 描述
	 */
	private String Description;

	/**
	 * 地理位置纬度
	 */
	private String Location_X;

	/**
	 * 地理位置经度
	 */
	private String Location_Y;

	/**
	 * 地图缩放大小
	 */
	private String Scale;

	/**
	 * 地理位置信息
	 */
	private String Label;

	/**
	 * 文本消息内容
	 */
	private String Content;

	/**
	 * 语音格式，如amr，speex等
	 */
	private String Format;

	private String Event;

	private String Latitude;

	private String Longitude;

	private String Precision;

	private String EventKey;

	private ScanCodeInfo ScanCodeInfo;

	private SendPicsInfo SendPicsInfo;

	private SendLocationInfo SendLocationInfo;

	private BatchJob BatchJob;
	
	private String Recognition;

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public ScanCodeInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}

	public SendPicsInfo getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	public SendLocationInfo getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	public BatchJob getBatchJob() {
		return BatchJob;
	}

	public void setBatchJob(BatchJob batchJob) {
		BatchJob = batchJob;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
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

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
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

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
