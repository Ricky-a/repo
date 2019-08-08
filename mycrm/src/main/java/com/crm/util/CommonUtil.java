package com.crm.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


public class CommonUtil {
	
	

	
	/**
	 * 转换时间格式的字符串为Timestamp类型
	 * @param time
	 * @return
	 */
	public static Timestamp getTimestampByStr(String time){
		Timestamp timestamp=null;
		if(time!=null && !time.equals("")){
			timestamp=Timestamp.valueOf(time);
		}
		return timestamp;
	}
	
	
	/**
	 * 获取返回客户端初始化响应的结果
	 */
	public static Map<String, Object> getResultMap() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("message", "网络出现异常，请稍后重试");
		resultMap.put("remark", "");
		resultMap.put("success", false);
		return resultMap;
	}
	
	
	
}
