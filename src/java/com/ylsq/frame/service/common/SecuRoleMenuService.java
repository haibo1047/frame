/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.common.SecuRoleMenuDao;
import com.ylsq.frame.model.common.SecuMenu;
import com.ylsq.frame.model.common.SecuRole;
import com.ylsq.frame.model.common.SecuRoleMenu;

/**
 * @author hopper
 *
 */
@Service
public class SecuRoleMenuService extends CommonService {
	@Resource
	private SecuRoleMenuDao secuRoleMenuDao;
	
	public List<SecuRole> findRoleListByMenuId(Long menuId){
		return secuRoleMenuDao.findRoleListByMenuId(menuId);
	}
	
	public List<SecuMenu> findListByRoleId(Long roleId){
		return secuRoleMenuDao.findListByRoleId(roleId);
	}
	
	public void saveRoleMenu(SecuRole role){
		deleteByRoleId(role.getId());
		
		if(role.getSelected() != null){
			SecuRole r = new SecuRole();;
			r.setId(role.getId());
			for(String str : role.getSelected()){
				String id = str.split(",")[0];
				if(StringUtils.isNumeric(id)){
					SecuMenu menu = new SecuMenu();
					menu.setId(Long.parseLong(id));
					SecuRoleMenu rm = new SecuRoleMenu();
					rm.setSecuMenu(menu);
					rm.setSecuRole(r);
					saveOrUpdateModel(SecuRoleMenu.class, rm);
				}
			}
		}
	}
	
	public void deleteByRoleId(Long roleId){
		secuRoleMenuDao.deleteByRoleId(roleId);
	}
}
