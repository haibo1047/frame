/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.common.SecuRoleDao;
import com.ylsq.frame.model.common.SecuUser;

/**
 * @author hopper
 *
 */

@Service
public class SecuRoleService extends CommonService {
	@Resource
	private SecuRoleDao secuRoleDao;
	public List<SecuUser> findUserListByRoleId(Long roleId){
		return secuRoleDao.findUserListByRoleId(roleId);
	}
}
