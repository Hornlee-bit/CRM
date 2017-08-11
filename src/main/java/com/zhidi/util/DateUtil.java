package com.zhidi.util;

import com.zhidi.base.exception.BaseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	/**
	 * 格式化日期时间
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(java.util.Date date,String pattern){
		if(date == null){
			return null;
		}
		return new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 将java.util.Date转换为java.sql.Date
	 * @param date -待转换的java.util.Date对象
	 * @return
	 */
	public static java.sql.Date toSQLDate(java.util.Date date){
		if(date!=null){
			return new java.sql.Date(date.getTime());
		}
		return null;
	}
	
	/**
	 * 将java.sql.Date转换为java.util.Date
	 * @param date -待转换的java.sql.Date对象
	 * @return
	 */
	public static java.util.Date toUtilDate(java.sql.Date date){
		if(date!=null){
			return new java.util.Date(date.getTime());
		}
		return null;
	}
	
	/**
	 * 将字符串日期时间按照指定的格式进行解析
	 */
	public static java.util.Date parseDate(String date, String pattern){
		if(date!=null && !date.isEmpty()){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new BaseException("在对字符串日期："+date+"，按照["+pattern+"]格式解析时出现异常", e);
			}
		}
		return null;
	}
	
	/**
	 * 根据指定的整数值创建日期对象
	 * @param year -年份值，如2017
	 * @param month -月份值，注意月份符合Java中月份规范，值的范围为0-11,0表示1月
	 * @param date -月中第多少天
	 * @param hourOfDay -一天的第几个小时，值从0-23
	 * @param minute -分钟数
	 * @param second -秒数
	 * @return -注意调用该方法返回的日期为当前平台所在时区为基准。
	 */
	public static java.util.Date createDate(int year, int month, int date, int hourOfDay, int minute, int second){
		Calendar c = Calendar.getInstance();
		c.set(year, month, date, hourOfDay, minute, second);
		return c.getTime();
	}
	
	/**
	* 根据指定的整数值创建日期对象
	 * @param year -年份值，如2017
	 * @param month -月份值，注意月份符合Java中月份规范，值的范围为0-11,0表示1月
	 * @param date -月中第多少天
	 * @param hourOfDay -一天的第几个小时，值从0-23
	 * @param minute -分钟数
	 * @return -注意调用该方法返回的日期为当前平台所在时区为基准，且返回的日期中秒为0
	 */
	public static java.util.Date createDate(int year, int month, int date, int hourOfDay, int minute){
		return createDate(year, month, date, hourOfDay, minute, 0);
	}
	
	/**
	 *根据指定的整数值创建日期对象
	 * @param year -年份值，如2017
	 * @param month -月份值，注意月份符合Java中月份规范，值的范围为0-11,0表示1月
	 * @param date -月中第多少天
	 * @return -注意调用该方法返回的日期为当前平台所在时区为基准，且返回的日期中时分秒均为0
	 */
	public static java.util.Date createDate(int year, int month, int date){
		return createDate(year, month, date, 0, 0);
	}
	
	/**
	 * 获取两个日期的天数差
	 * @param begin -起始日期
	 * @param end -结束日期
	 * @return end参数和begin参数之间的日期差值，当不足一天时直接舍弃。
	 */
	public static int diffDate(java.util.Date begin, java.util.Date end){
		//jdk8中有关于日期间隔的实现，此处采用自己的实现吧
		long beginTime = begin.getTime();
		long endTime = begin.getTime();
		
		return (int)( (endTime-beginTime) / (24*60*60*1000) );
	}
	

}
