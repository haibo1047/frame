/**
 * 
 */
package com.ylsq.frame.dao.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.model.common.SecuUser;

/**
 * @author hopper
 *
 */
@Repository
public class SecuRoleDao extends CommonDao {

	public List<SecuUser> findUserListByRoleId(Long roleId){
		Query query = getSession().createQuery("select secuUser from SecuUserRole o where o.secuRole.id=?");
		query.setLong(0, roleId);
		return query.list();
	}
}
