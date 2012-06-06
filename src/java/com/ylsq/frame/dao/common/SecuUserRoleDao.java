/**
 * 
 */
package com.ylsq.frame.dao.common;

import org.springframework.stereotype.Repository;

/**
 * @author hopper
 *
 */

@Repository
public class SecuUserRoleDao extends CommonDao {
	public void deleteByRoleId(Long roleId){
		getSession().createQuery("delete from SecuUserRole o where o.secuRole.id = ?").setLong(0, roleId).executeUpdate();
	}
}
