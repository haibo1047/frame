package com.ylsq.frame.web.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.compare.SecuMenuComparator;
import com.ylsq.frame.model.common.SecuMenu;
import com.ylsq.frame.service.common.SecuMenuService;
import com.ylsq.frame.utils.SecurityUtils;
import com.ylsq.frame.utils.SpringProperties;

@Controller
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private SecuMenuService secuMenuService;
	@Autowired
	private SpringProperties springProperties;
	@RequestMapping("/main")
	public void index(Model model){
		logger.debug("index");
		model.addAttribute("systemName", springProperties.getSystemName());
	}
	
	
	@RequestMapping("/expose/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/top")
	public void top(Model model){
		logger.debug(springProperties.getSystemName());
	}
	
	@RequestMapping("/leftMenu")
	public void leftMenu(Model model){
		String username = SecurityUtils.fetchUsername();
		if(StringUtils.isNotBlank(username)){
			List<SecuMenu> menuList = secuMenuService.findListByUsername(username);
			Collections.sort(menuList,new SecuMenuComparator());
			List<String> firstLevel = new ArrayList<String>();
			Map<String,List<SecuMenu>> menuMap = new HashMap<String, List<SecuMenu>>();
			for(SecuMenu m : menuList){
				String str = m.getMenuPath().split(SecuMenu.MENU_SPLIT)[1];
				if(!firstLevel.contains(str)){
					firstLevel.add(str);
				}
				List<SecuMenu> list = menuMap.get(str);
				if(list == null){
					list = new ArrayList<SecuMenu>();
					menuMap.put(str, list);
				}
				list.add(m);
			}
			model.addAttribute("firstLevel",firstLevel);
			model.addAttribute("menuMap",menuMap);
		}
	}
}
