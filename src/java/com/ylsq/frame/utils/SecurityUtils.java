/**
 * 
 */
package com.ylsq.frame.utils;

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
}
