/**
 * 
 */
package com.ylsq.frame.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping("/addMenu")
	public String addMenu(Model model){
		model.addAttribute("menu", new SecuMenu());
		return "/menu/addMenu";
	}
	
	@RequestMapping("editMenu")
	public String editMenu(Long id,Model model){
		SecuMenu menu = commonService.findById(SecuMenu.class, id);
		model.addAttribute("menu", menu);
		return "/menu/addMenu";
	}
	
	@RequestMapping("/saveMenu")
	public String saveMenu(@ModelAttribute("menu") SecuMenu menu,Model model){
		menu.setMenuName(menu.getMenuPath().substring(menu.getMenuPath().lastIndexOf("//")+2));
		logger.debug(menu.getMenuPath());
		commonService.saveOrUpdateModel(SecuMenu.class,menu);
		
		return list(model);
	}
	
	@RequestMapping("/delete")
	public String deleteMenu(Long menuId,Model model){
		SecuMenu  menu  = new SecuMenu();
		menu.setId(menuId);
		commonService.deleteModel(SecuMenu.class,menu);
		return list(model);
	}
}
