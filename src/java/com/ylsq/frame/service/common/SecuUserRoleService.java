/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.common.SecuUserRoleDao;
import com.ylsq.frame.model.common.SecuRole;
import com.ylsq.frame.model.common.SecuUser;
import com.ylsq.frame.model.common.SecuUserRole;

/**
 * @author hopper
 *
 */
@Service
public class SecuUserRoleService extends CommonService {
	
	@Resource
	private SecuUserRoleDao secuUserRoleDao;
	public List<SecuRole> findRoleListByUserId(Long userId){
		SecuUserRole example = new SecuUserRole();
		SecuUser secuUser = new SecuUser();
		secuUser.setId(userId);
		example.setSecuUser(secuUser);
		List<SecuUserRole> urList =  find(SecuUserRole.class, example);
		List<SecuRole> roleList = new ArrayList<SecuRole>();
		for(SecuUserRole sur : urList){
			roleList.add(sur.getSecuRole());
		}
		return roleList;
	}
	public List<SecuUserRole> findListByUserId(Long userId){
		SecuUserRole example = new SecuUserRole();
		SecuUser secuUser = new SecuUser();
		secuUser.setId(userId);
		example.setSecuUser(secuUser);
		List<SecuUserRole> urList =  find(SecuUserRole.class, example);
		return urList;
	}
	
	public void saveUserRole(SecuRole role){
		deleteByRoleId(role.getId());
		
		if(role.getSelected() != null){
			SecuRole r = new SecuRole();;
			r.setId(role.getId());
			for(String str : role.getSelected()){
				SecuUser u = new SecuUser();
				String id = str.split(",")[0];
				if(StringUtils.isNumeric(id)){
					u.setId(Long.parseLong(id));
					SecuUserRole ur = new SecuUserRole();
					ur.setSecuRole(r);
					ur.setSecuUser(u);
					
					saveOrUpdateModel(SecuUserRole.class, ur);
				}
			}
		}
	}
	
	public void deleteByRoleId(Long roleId){
		secuUserRoleDao.deleteByRoleId(roleId);
	}
}
