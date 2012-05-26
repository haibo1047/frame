/**
 * 
 */
package com.ylsq.frame.utils;

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
		System.out.println(getSimpleSpell("在哪"));
		Md5PasswordEncoder enc = new Md5PasswordEncoder();
		System.out.println(enc.encodePassword("user", null));
	}

	public static String getSimpleSpell(String in){
		StringBuffer r = new StringBuffer();
		for(char c : in.toCharArray()){
			String []sa = PinyinHelper.toHanyuPinyinStringArray(c);
			r.append(sa[0].charAt(0));
		}
		return r.toString();
	}
	
	public static String md5code(String src){
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder.encodePassword(src, null);
	}
}
