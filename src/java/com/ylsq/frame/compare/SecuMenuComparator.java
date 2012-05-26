/**
 * 
 */
package com.ylsq.frame.compare;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

import com.ylsq.frame.model.common.SecuMenu;

/**
 * @author hopper
 *
 */
public class SecuMenuComparator implements Comparator<SecuMenu>{

	@Override
	public int compare(SecuMenu o1, SecuMenu o2) {
		if(o2 == null)
			return 1;
		if(StringUtils.isNotEmpty(o2.getMenuOrder())){
			if(StringUtils.isEmpty(o1.getMenuOrder())){
				return -1;
			}
			String []srcArray = StringUtils.split(o1.getMenuOrder(),"-");
			String []oArray = StringUtils.split(o2.getMenuOrder(),"-");
			for(int index = 0; index<srcArray.length ;index++){
				if(index >= oArray.length){
					return 1;
				}
				int so = 0,oo = 0;
				if(StringUtils.isNumeric(srcArray[index])){
					so = Integer.parseInt(srcArray[index]);
				}
				if(StringUtils.isNumeric(oArray[index])){
					oo = Integer.parseInt(oArray[index]);
				}
				if(so != oo){
					return so - oo;
				}
			}
			if(oArray.length>srcArray.length){
				return -1;
			}
		}
		else if(StringUtils.isNotBlank(o2.getMenuOrder())){
			return -1;
		}
		
		return o1.getMenuPath().compareTo(o2.getMenuPath());
	}

}
