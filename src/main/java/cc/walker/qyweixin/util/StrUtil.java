package cc.walker.qyweixin.util;

public class StrUtil {

	public static boolean notBlank(String str) {
		if (str == null || "".equals(str.trim())) return false;
		return true;
	}
}
