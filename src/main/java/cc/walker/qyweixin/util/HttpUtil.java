package cc.walker.qyweixin.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

import cc.walker.qyweixin.api.result.MaterialGetJson;
import cc.walker.qyweixin.api.result.MaterialGetResult;
import cc.walker.qyweixin.api.result.MediaGetResult;
import cc.walker.qyweixin.cnst.QyWechatConfig;

public class HttpUtil {
	
	private static final Logger log = Logger.getLogger(HttpUtil.class);
	private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36";
	
	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 * @throws Exception 
	 */
	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		String result = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			result = buffer.toString();
		} catch (ConnectException ce) {
			ce.printStackTrace();
			log.error(ce.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 发起http请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return 字符串
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		String result = null;
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn =  (HttpURLConnection) url.openConnection();

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			result = buffer.toString();
		} catch (ConnectException ce) {
			ce.printStackTrace();
			log.error(ce.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 文件上传
	 * 
	 * @param requestUrl 
	 * 						文件上传地址
	 * @param file 
	 * 						需要上传的文件
	 * @return {String}
	 * 						返回的字符串
	 */
	public static String postFile(String requestUrl, File file) {
		String result = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod("POST");
			
			DataInputStream in = new DataInputStream(new FileInputStream(file));  
			OutputStream outputStream = httpUrlConn.getOutputStream();
			int bytes = 0;  
            byte[] bytebuffer = new byte[1024];  
            while ((bytes = in.read(bytebuffer)) != -1) {  
            	outputStream.write(bytebuffer, 0, bytes);  
            }
            in.close();
            outputStream.flush();
			outputStream.close();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			result = buffer.toString();
		} catch (ConnectException ce) {
			ce.printStackTrace();
			log.error(ce.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @param downloadUrl
	 * 						下载地址
	 * @return
	 */
	public static MediaGetResult getMedia(String downloadUrl) {
		MediaGetResult result = new MediaGetResult();
		InputStream in = null;
        BufferedReader read = null;
		try {
			URL _url = new URL(downloadUrl);
	        HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
	        // 连接超时
	        conn.setConnectTimeout(25000);
	        // 读取超时 --服务器响应比较慢，增大时间
	        conn.setReadTimeout(25000);
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	        conn.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.connect();
        	in = conn.getInputStream();
        	read = new BufferedReader(new InputStreamReader(in));
	        if(conn.getContentType().equalsIgnoreCase("text/plain")){
	            // 定义BufferedReader输入流来读取URL的响应
	            String valueString = null;
	            StringBuffer bufferRes = new StringBuffer();
	            while ((valueString = read.readLine()) != null){
	                bufferRes.append(valueString);
	            }
	            result = JsonUtil.fromJson(bufferRes.toString(), MediaGetResult.class);
	        }else{
	            String valueString = null;
	            String ds = conn.getHeaderField("Content-disposition");
	            String fileName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
	            File resultFile = new File(QyWechatConfig.getTmpSavePath() + fileName);
	            FileWriter fw = new FileWriter(resultFile);
	            while ((valueString = read.readLine()) != null){
	                fw.write(valueString);
	            }
	            fw.flush();
	            fw.close();
	            result.setFile(resultFile);
	            result.setErrcode(0);
	            result.setErrmsg("success");
	        }
	        read.close();
	        in.close();
        } catch (Exception e) {
        	log.error(e.getMessage());
        	result.setErrcode(99999);
        	result.setErrmsg(e.getMessage());
        } finally {
        	if (in != null) {
        		try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
        	if (read != null) {
        		try {
					read.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
        }
        return result;
	}
	
	/**
	 * 
	 * @param downloadUrl
	 * 						下载地址
	 * @return
	 */
	public static MaterialGetResult getMaterial(String downloadUrl) {
		MaterialGetResult result = new MaterialGetResult();
		InputStream in = null;
        BufferedReader read = null;
		try {
			URL _url = new URL(downloadUrl);
	        HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
	        // 连接超时
	        conn.setConnectTimeout(25000);
	        // 读取超时 --服务器响应比较慢，增大时间
	        conn.setReadTimeout(25000);
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	        conn.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.connect();
        	in = conn.getInputStream();
        	read = new BufferedReader(new InputStreamReader(in));
	        if(conn.getContentType().equalsIgnoreCase("text/plain")){
	            // 定义BufferedReader输入流来读取URL的响应
	            String valueString = null;
	            StringBuffer bufferRes = new StringBuffer();
	            while ((valueString = read.readLine()) != null){
	                bufferRes.append(valueString);
	            }
	            if (bufferRes.indexOf("\"errcode\"") != -1) {
	            	result = JsonUtil.fromJson(bufferRes.toString(), MaterialGetResult.class);
	            }
	            else {
		            MaterialGetJson json = JsonUtil.fromJson(bufferRes.toString(), MaterialGetJson.class);
		            result.setJson(json);
		            result.setErrcode(0);
		            result.setErrmsg("success");
	            }
	        }else{
	            String valueString = null;
	            String ds = conn.getHeaderField("Content-disposition");
	            String fileName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
	            File resultFile = new File(QyWechatConfig.getTmpSavePath() + fileName);
	            FileWriter fw = new FileWriter(resultFile);
	            while ((valueString = read.readLine()) != null){
	                fw.write(valueString);
	            }
	            fw.flush();
	            fw.close();
	            result.setFile(resultFile);
	            result.setErrcode(0);
	            result.setErrmsg("success");
	        }
	        read.close();
	        in.close();
        } catch (Exception e) {
        	log.error(e.getMessage());
        	result.setErrcode(99999);
        	result.setErrmsg(e.getMessage());
        } finally {
        	if (in != null) {
        		try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
        	if (read != null) {
        		try {
					read.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
        }
        return result;
	}
}
