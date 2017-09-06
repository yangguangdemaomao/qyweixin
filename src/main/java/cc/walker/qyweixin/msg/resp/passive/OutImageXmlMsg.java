package cc.walker.qyweixin.msg.resp.passive;

/**
 * 被动响应,image消息
 * @author walker
 *
 */
public class OutImageXmlMsg extends OutBaseXmlMsg {

	private ImageXml Image;

	public ImageXml getImage() {
		return Image;
	}

	public void setImage(ImageXml image) {
		Image = image;
	}
}
