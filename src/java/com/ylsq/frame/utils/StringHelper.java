/**
 * 
 */
package com.ylsq.frame.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author hopper
 *
 */
public class StringHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getSimpleSpell(""));
		System.out.println(firstCharUpper(" aAc"));
		Md5PasswordEncoder enc = new Md5PasswordEncoder();
		System.out.println(enc.encodePassword("user", null));
	}

	public static String getSimpleSpell(String in){
		StringBuffer r = new StringBuffer();
		if(in.equals("复方α-酮酸")){
			System.out.println(in);
		}
		for(int index = 0; index<in.length() ; index++){
			String c = in.substring(index,index+1);
			if(c.getBytes().length == 1){
				r.append(c);
			}
			else{
				String []sa = PinyinHelper.toHanyuPinyinStringArray(c.charAt(0));
				if(sa != null){
					r.append(sa[0].charAt(0));
				}
			}
		}
		return r.toString();
	}
	
	public static String md5code(String src){
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder.encodePassword(src, null);
	}
	
	public static String firstCharUpper(String src){
		if(StringUtils.isNotBlank(src)){
			src = src.trim().toLowerCase();
			String upper = src.toUpperCase();
			return upper.charAt(0)+src.substring(1);
		}
		return null;
	}
}
