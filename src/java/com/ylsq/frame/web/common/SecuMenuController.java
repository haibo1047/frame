/**
 * 
 */
package com.ylsq.frame.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

	@Override
	protected void beforeSave() {
		object = (SecuMenu)object;
		object.setMenuName(object.getMenuPath().substring(object.getMenuPath().lastIndexOf("//")+2));
	}


}
