/**
 * 
 */
package com.ylsq.frame.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author hopper
 *
 */
public class SecurityUtils {

	public static String fetchUsername(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.getName() != null){
			return auth.getName();
		}
		return null;
	}
	
	public static boolean isSuperAdmin(){
		String username = fetchUsername();
		if(StringUtils.isNotBlank(username) && username.equals("root")){
			return true;
		}
		return false;
	}
}
