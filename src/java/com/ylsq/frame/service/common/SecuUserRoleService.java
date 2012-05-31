/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ylsq.frame.model.common.SecuRole;
import com.ylsq.frame.model.common.SecuUser;
import com.ylsq.frame.model.common.SecuUserRole;

/**
 * @author hopper
 *
 */
@Service
public class SecuUserRoleService extends CommonService {
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
}
