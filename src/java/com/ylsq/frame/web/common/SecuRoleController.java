/**
 * 
 */
package com.ylsq.frame.web.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.SecuRole;
import com.ylsq.frame.model.common.SecuUser;
import com.ylsq.frame.service.common.SecuRoleService;

/**
 * @author hopper
 *
 */
@Controller
@RequestMapping("role")
public class SecuRoleController extends CommonController<SecuRole> {
	@Autowired
	private SecuRoleService secuRoleService;
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

	@RequestMapping("/configUser")
	public String configUser(Long id,Model model){
		List<SecuUser> userList = secuRoleService.findUserListByRoleId(id);
		model.addAttribute("userList", userList);
		return dir()+"/configUser";
	}
	
	@RequestMapping("saveConfigUser")
	public String saveConfigUser(Long roleId,Model model){
		return configUser(roleId,model);
	}
}
