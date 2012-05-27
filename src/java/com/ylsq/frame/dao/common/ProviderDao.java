/**
 * 
 */
package com.ylsq.frame.dao.common;

import org.hibernate.Criteria;

import com.ylsq.frame.model.common.Provider;

/**
 * @author hopper
 *
 */
public class ProviderDao extends CommonDao {
	public Provider findProviderByName(String providerName){
		Criteria criteria = getSession().createCriteria(Provider.class, "providerName");
		criteria.list();
		return null;
	}
}
