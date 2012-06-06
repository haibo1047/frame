/**
 * 
 */
package com.ylsq.frame.dao.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.model.common.SecuMenu;
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
	
	public List<SecuMenu> findListByRoleId(Long roleId){
		Query query = getSession().createQuery("select o.secuMenu from SecuRoleMenu o where o.secuRole.id = ?");
		query.setLong(0, roleId);
		return query.list();
	}
	
	public void deleteByRoleId(Long roleId){
		getSession().createQuery("delete from SecuRoleMenu o where o.secuRole.id=?").setLong(0, roleId).executeUpdate();
	}
}
