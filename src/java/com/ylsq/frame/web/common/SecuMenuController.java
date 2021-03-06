/**
 * 
 */
package com.ylsq.frame.web.common;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.SecuMenu;

/**
 * @author hopper
 *
 */

@Controller
@RequestMapping("menu")
public class SecuMenuController extends CommonController<SecuMenu>{
	private static Logger logger = LoggerFactory.getLogger(SecuMenuController.class);
	
	@Override
	protected String dir() {
		return "menu";
	}

	@Override
	protected Class<SecuMenu> getObjectClass() {
		return SecuMenu.class;
	}

	@RequestMapping("ssave")
	public String ssave(@Valid SecuMenu menu,BindingResult result,Model model){
		return save(menu, model);
	}
	@Override
	protected void beforeSave() {
		logger.debug("before");
		object.setMenuName(object.getMenuPath().substring(object.getMenuPath().lastIndexOf(SecuMenu.MENU_SPLIT)+2));
	}
}
