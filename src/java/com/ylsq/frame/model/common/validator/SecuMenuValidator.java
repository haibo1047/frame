/**
 * 
 */
package com.ylsq.frame.model.common.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ylsq.frame.model.common.SecuMenu;

/**
 * @author hopper
 *
 */
public class SecuMenuValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(SecuMenu.class);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "menuPath", "路径不能为空");
		ValidationUtils.rejectIfEmpty(err, "menuUrl", "URL不能为空");
		SecuMenu menu = (SecuMenu)obj;
		if(!menu.getMenuPath().startsWith(SecuMenu.MENU_SPLIT)){
			err.reject("menuPath", "菜单路径必须以"+SecuMenu.MENU_SPLIT+"开头");
		}
		if(!menu.getMenuUrl().startsWith(SecuMenu.MENU_SPLIT)){
			err.reject("menuUrl", "URL必须以"+SecuMenu.MENU_SPLIT+"开头");
		}
	}
}
