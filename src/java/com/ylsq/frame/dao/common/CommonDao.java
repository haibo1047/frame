/**
 * 
 */
package com.ylsq.frame.dao.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.model.common.PK;

/**
 * @author hopper
 *
 */

@Repository("commonDao")
public class CommonDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public <T> void saveOrUpdateModel(Class<T> clazz,T model){
		getSession().saveOrUpdate(model);
	}

	@SuppressWarnings("unchecked")
	public <T extends PK> List<T> findAll(Class<T> clazz){
		return (List<T>)getSession().createCriteria(clazz).list();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PK> T findById(Class<T> clazz,Long id){
		return (T)getSession().get(clazz, id);
	}
	
	public <T extends PK> void delete(T model){
		getSession().delete(model);
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
