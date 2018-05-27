/**
 * 
 */
package com.hubena.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hubena.entity.RequestStudent;

/**
 * Json工具类.
 * @author 曾谢波
 * @since 2018年5月25日上午12:00:37
 */
public class JsonUtils {
//  private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	/**
	 * 将JsonString解析为指定类型的JavaBean.
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static final <T> T parseToObject(String jsonString, Class<T> clazz){
		return JSON.parseObject(jsonString, clazz);
	}
	
	/**
	 * 将JsonString字符串解析为JsonObject.
	 * @param jsonString Json格式字符串
	 * @return 
	 */
	public static JSONObject parseToJsonObject(String jsonString){
		return JSON.parseObject(jsonString);
	}

	/**
	 * JavaBean对象解析为Json字符串.
	 * @param student
	 * @return
	 */
	public static String objectToJsonString(Object student) {
		return JSON.toJSONString(student);
	}
	
	/**
	 * 将JsonString字符串解析为JsonObject或JsonArray.
	 * @param jsonString
	 * @return
	 */
	public static Object parseToJsonObjectOrJsonArray(String jsonString) {
		return JSON.parse(jsonString);
	}
	
	
}
