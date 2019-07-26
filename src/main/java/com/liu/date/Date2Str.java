package com.liu.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2Str {

	public static final String Y_M_D = "yyyy-MM-dd";
	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String Y = "yyyy";

	/**  日期转化  **/
	public static String date2Str(Date date, String style){
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		String dataStr = sdf.format(date);
		return dataStr;
	}
}
