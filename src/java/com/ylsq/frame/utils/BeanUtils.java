/**
 * 
 */
package com.ylsq.frame.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ylsq.frame.model.common.PK;

/**
 * @author hopper
 *
 */
public class BeanUtils {

	public static <T extends PK> Map<Long,T> convertToMap(List<T> list){
		if(list != null){
			Map<Long,T> map = new HashMap<Long, T>();
			for(T t : list){
				map.put(t.getId(), t);
			}
			return map;
		}
		return null;
	}
}
