/**
 * 
 */
package com.ylsq.frame.dao.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.model.common.SecuMenu;

/**
 * @author hopper
 *
 */
@Repository
public class SecuMenuDao extends CommonDao{

	public List<SecuMenu> findListByUsername(String loginName){
		Query query = getSession().createQuery("select rm.secuMenu from SecuRoleMenu rm,SecuUserRole ur where ur.secuRole.id=rm.secuRole.id and ur.secuUser.username=?");
		query.setString(0, loginName);
		return query.list();
	}
}
