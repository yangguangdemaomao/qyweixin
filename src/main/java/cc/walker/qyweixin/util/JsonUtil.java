package cc.walker.qyweixin.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * google gson工具类
 * 
 * @author walker
 * @date 2016-09-05
 */
public class JsonUtil {
	
	/**
	 * 把对象序列化为字符串，如果字段为空,也会转换
	 * @param obj
	 * @return String
	 */
	public static String toJsonWithNulls(Object obj) {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting()
				.disableHtmlEscaping().create();
		return gson.toJson(obj);
	}
	
	/**
	 * 把对象序列化为字符串，如果字段为空,不会转换
	 * @param obj
	 * @return String
	 */
	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.disableHtmlEscaping().create();
		return gson.toJson(obj);
	}
	
	/**
	 * 字符串转换成json对象
	 * @param json
	 * @param klass
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> klass) {
		Gson gson = new GsonBuilder()
		.disableHtmlEscaping().create();
		T obj = gson.fromJson(json, klass);
		return obj;
	}
	
	/**
	 * 字符串转换成json对象
	 * @param json
	 * @param klass
	 * @return
	 */
	public static <T> T fromJson(String json, Type type) {
		Gson gson = new GsonBuilder()
		.disableHtmlEscaping().create();
		T obj = gson.fromJson(json, type);
		return obj;
	}
}
