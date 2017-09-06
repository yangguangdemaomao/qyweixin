package cc.walker.qyweixin.api.result;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import cc.walker.qyweixin.cnst.ErrCode2Msg;
import cc.walker.qyweixin.util.JsonUtil;

/**
 * 调用API接口返回
 * @author walker
 *
 */
public class ApiResult {

    private Map<String, Object> attrs;
    private String json;

    /**
     * 通过 json 构造 ApiResult，注意返回结果不为 json 的 api（如果有的话）
     * @param jsonStr json字符串
     */
    @SuppressWarnings("unchecked")
    public ApiResult(String jsonStr) {
        this.json = jsonStr;

        try {
            Map<String, Object> temp = JsonUtil.fromJson(jsonStr, Map.class);
            this.attrs = temp;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过 json 创建 ApiResult 对象，等价于 new ApiResult(jsonStr)
     * @param jsonStr json字符串
     * @return {ApiResult}
     */
    public static ApiResult create(String jsonStr) {
        return new ApiResult(jsonStr);
    }

    public String getJson() {
        return json;
    }

    public String toString() {
        return getJson();
    }

    /**
     * APi 请求是否成功返回
     * @return {boolean}
     */
    public boolean isSucceed() {
        Integer errorCode = getErrorCode();
        // errorCode 为 0 时也可以表示为成功，详见：http://mp.weixin.qq.com/wiki/index.php?title=%E5%85%A8%E5%B1%80%E8%BF%94%E5%9B%9E%E7%A0%81%E8%AF%B4%E6%98%8E
        return (errorCode == null || errorCode == 0);
    }

    public Integer getErrorCode() {
        return getInt("errcode");
    }

    public String getErrorMsg() {
        Integer errorCode = getErrorCode();
        if (errorCode != null) {
            String result = ErrCode2Msg.getMsg(errorCode);
            if (result != null)
                return result;
        }
        return (String)attrs.get("errmsg");
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T)attrs.get(name);
    }

    public String getStr(String name) {
        return (String)attrs.get(name);
    }

    public Integer getInt(String name) {
        Number number = (Number) attrs.get(name);
        return number == null ? null : number.intValue();
    }

    public Long getLong(String name) {
        Number number = (Number) attrs.get(name);
        return number == null ? null : number.longValue();
    }

    public BigInteger getBigInteger(String name) {
        return (BigInteger)attrs.get(name);
    }

    public Double getDouble(String name) {
        return (Double)attrs.get(name);
    }

    public BigDecimal getBigDecimal(String name) {
        return (BigDecimal)attrs.get(name);
    }

    public Boolean getBoolean(String name) {
        return (Boolean)attrs.get(name);
    }

    @SuppressWarnings("rawtypes")
    public List getList(String name) {
        return (List)attrs.get(name);
    }

    @SuppressWarnings("rawtypes")
    public Map getMap(String name) {
        return (Map)attrs.get(name);
    }
}
