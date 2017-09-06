package cc.walker.qyweixin.util;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XmlUtil {
	
	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2016-09-07
	 */
	private static XStream getXStream() {
		XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;
		
				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}
		
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		});
		xstream.autodetectAnnotations(true);
		return xstream;
	}
	
	/**
	 * 将java对象转换成xml
	 * @param obj
	 * @return
	 */
	public  static String toXml(Object obj) {
		XStream xstream = getXStream();
		return xstream.toXML(obj);
	}

	/**
	 * 将java对象转换成xml
	 * @param obj
	 * @param xmlClass
	 * @return
	 */
	public  static String toXml(Object obj, Class<?> xmlClass) {
		XStream xstream = getXStream();
		xstream.alias("xml", xmlClass);
		return xstream.toXML(obj);
	}
	
	/**
	 * 将java对象转换成xml
	 * @param obj
	 * @param t
	 * @return
	 */
	public  static String toXml(Object obj, Class<?> t[]) {
		XStream xstream = getXStream();
		for (Class<?> tmp : t) {
			xstream.alias(t.getClass().getName(), tmp);
		}
		return xstream.toXML(obj);
	}
	
	/**
	 * 将java对象转换成xml
	 * @param obj
	 * @param t
	 * @return
	 */
	public  static String toXml(Object obj, Class<?> t[], Class<?> xmlClass) {
		XStream xstream = getXStream();
		for (Class<?> tmp : t) {
			xstream.alias(t.getClass().getName(), tmp);
		}
		return xstream.toXML(obj);
	}
	
	/**
	 * 将xml转换成java对象
	 * @param xml 需要转换成对象的xml
	 * @param xmlClass 这个参数的类型，自动转换为xml标签
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  static <T> T fromXml(String xml, Class<T> xmlClass) {
		XStream xstream = getXStream();
		xstream.alias("xml", xmlClass);
		return (T) xstream.fromXML(xml);
	}
	
	/**
	 * 将xml转换成java对象
	 * @param xml 需要转换成对象的xml
	 * @param t 需要转换的列表，自动转换为该类名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  static <T> T fromXml(String xml, Class<?> t[]) {
		XStream xstream = getXStream();
		for (Class<?> tmp : t) {
			xstream.alias(t.getClass().getName(), tmp);
		}
		return (T) xstream.fromXML(xml);
	}
	
	/**
	 * 将xml转换成java对象
	 * @param xml 需要转换成对象的xml
	 * @param t 需要转换的列表，自动转换为该类名
	 * @param xmlClass 这个参数的类型，自动转换为xml标签
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  static <T> T fromXml(String xml, Class<?> t[], Class<T> xmlClass) {
		XStream xstream = getXStream();
		for (Class<?> tmp : t) {
			xstream.alias(t.getClass().getName(), tmp);
		}
		xstream.alias("xml", xmlClass);
		return (T) xstream.fromXML(xml);
	}
}
