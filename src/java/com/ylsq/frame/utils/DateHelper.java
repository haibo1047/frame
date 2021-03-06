/**
 * 
 */
package com.ylsq.frame.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author hopper
 *
 */
public class DateHelper {
	private static Log logger = LogFactory.getLog(DateHelper.class);
	public static void main(String[] args) {
		logger.debug(parseDate("2012-10-12"));
	}
	
	public static Date parseDate(String string){
		try {
			String pattern = "yyyyMMdd";
			if(string.indexOf("-")>-1){
				pattern = "yyyy-MM-dd";
			}
			return org.apache.commons.lang3.time.DateUtils.parseDate(string, pattern);
		} catch (ParseException e) {
			logger.warn("parse exception");
		}
		return null;
	}

	public static String parseDate(Date date,String pattern){
		DateFormat df = new SimpleDateFormat(StringUtils.defaultString(pattern, "yyyy-mm-dd"));
		if(date == null)
			date = new Date();
		return df.format(date);
	}
}
