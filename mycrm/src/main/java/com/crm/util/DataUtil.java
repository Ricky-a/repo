package com.crm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author admin
 *
 */
public class DataUtil {

	/**
	 * 获取当前时间
	 * 
	 * @return
	 * @throws ParseException 
	 */
	public static Date renewDate() {
		/*** 设置日期格式 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
