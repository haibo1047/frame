/**
 * 
 */
package com.ylsq.frame.dao.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.model.common.SecuRole;

/**
 * @author hopper
 *
 */

@Repository
public class SecuRoleMenuDao extends CommonDao {
	public List<SecuRole> findRoleListByMenuId(Long menuId){
		Query query = getSession().createQuery("select o.secuRole from SecuRoleMenu o where o.secuMenu.id = ?");
		query.setLong(0, menuId);
		return query.list();
	}
}
