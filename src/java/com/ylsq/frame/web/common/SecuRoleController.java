/**
 * 
 */
package com.ylsq.frame.web.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.SecuMenu;
import com.ylsq.frame.model.common.SecuRole;
import com.ylsq.frame.model.common.SecuUser;
import com.ylsq.frame.service.common.SecuRoleMenuService;
import com.ylsq.frame.service.common.SecuRoleService;
import com.ylsq.frame.service.common.SecuUserRoleService;

/**
 * @author hopper
 *
 */
@Controller
@RequestMapping("role")
public class SecuRoleController extends CommonController<SecuRole> {
	@Autowired
	private SecuRoleService secuRoleService;
	
	@Autowired
	private SecuUserRoleService secuUserRoleService;
	
	@Autowired
	private SecuRoleMenuService secuRoleMenuService;

	@Override
	protected String dir() {
		return "role";
	}

	@Override
	protected Class<SecuRole> getObjectClass() {
		return SecuRole.class;
	}

	@Override
	protected void beforeSave() {
		object.setAuthority(object.getAuthority().toUpperCase());
	}

	@RequestMapping("configUser")
	public String configUser(Long id,Model model){
		List<SecuUser> selectedUsers = secuRoleService.findUserListByRoleId(id);
		Set<Long> selectIds = new HashSet<Long>();
		for(SecuUser u : selectedUsers){
			selectIds.add(u.getId());
		}
		List<SecuUser> allUser = commonService.findAll(SecuUser.class);
		List<SecuUser> unselectUsers = new ArrayList<SecuUser>(allUser.size()-selectIds.size());
		for(SecuUser u : allUser){
			if(!selectIds.contains(u.getId())){
				unselectUsers.add(u);
			}
		}
		model.addAttribute("selectedUsers", selectedUsers);
		model.addAttribute("unselectUsers", unselectUsers);
		model.addAttribute("object", secuRoleService.findById(SecuRole.class, id));
		objectDir(model);
		return dir()+"/configUser";
	}
	
	@RequestMapping("saveConfigUser")
	public String saveConfigUser(@ModelAttribute SecuRole role,Model model){
		secuUserRoleService.saveUserRole(role);
		return configUser(role.getId(),model);
	}
	
	@RequestMapping("configMenu")
	public String configMenu(Long id,Model model){
		List<SecuMenu> selectedMenus = secuRoleMenuService.findListByRoleId(id);
		Set<Long> existIds = new HashSet<Long>();
		for(SecuMenu m : selectedMenus){
			existIds.add(m.getId());
		}
		List<SecuMenu> allMenu = commonService.findAll(SecuMenu.class);
		List<SecuMenu> unselectMenus = new ArrayList<SecuMenu>(allMenu.size()-existIds.size());
		for(SecuMenu menu : allMenu){
			if(!existIds.contains(menu.getId())){
				unselectMenus.add(menu);
			}
		}
		model.addAttribute("selected", selectedMenus);
		model.addAttribute("unselect", unselectMenus);
		model.addAttribute("object", secuRoleService.findById(SecuRole.class, id));
		objectDir(model);
		return dir()+"/menuConfig";
	}
	
	@RequestMapping("saveConfigRole")
	public String saveConfigRole(@ModelAttribute SecuRole role,Model model){
		secuRoleMenuService.saveRoleMenu(role);
		return configMenu(role.getId(), model);
	}
}
