/**
 * 
 */
package com.ylsq.frame.utils;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * @author hopper
 *
 */
public class PoiHelper {

	public static void main(String[] args) {
	}

	@SuppressWarnings("unchecked")
	public static <T> T parseCell(HSSFCell cell,Class<T> clazz){
		if(cell == null)
			return null;
		T var = null;
		if(clazz == String.class){
			var = (T)cell.getStringCellValue();
		}
		else if(clazz == Date.class){
			var = (T)cell.getDateCellValue();
		}
		else if(clazz == Double.class){
			Double v = cell.getNumericCellValue();
			var = (T)v;
		}
		else if(clazz == Long.class){
			Double v = cell.getNumericCellValue();
			var = (T)new Long(v.longValue());
		}
		else if(clazz == Integer.class){
			Double v = cell.getNumericCellValue();
			var = (T)new Integer(v.intValue());
		}
		return var;
	}
}
