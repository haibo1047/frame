/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.common.SecuRoleMenuDao;
import com.ylsq.frame.model.common.SecuRole;

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
}
