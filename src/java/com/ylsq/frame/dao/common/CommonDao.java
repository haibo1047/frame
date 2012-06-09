/**
 * 
 */
package com.ylsq.frame.dao.common;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.model.common.PK;

/**
 * @author hopper
 *
 */

@Repository("commonDao")
public class CommonDao{
	public static int BATCH_OP_NUM = 200;
	@Resource
	private SessionFactory sessionFactory;
	public <T> void saveOrUpdateModel(Class<T> clazz,T model){
		getSession().saveOrUpdate(model);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PK> List<T> find(Class<T> clazz,T example){
		if(example == null){
			return findAll(clazz);
		}
		return getSession().createCriteria(clazz).add(Example.create(example)).list();
	}

	@SuppressWarnings("unchecked")
	public <T extends PK> List<T> findAll(Class<T> clazz){
		return (List<T>)getSession().createCriteria(clazz).list();
	}
	
	public <T extends PK> boolean saveAll(Class<T> clazz,List<T> list){
		for(int index=1;index<=list.size();index++){
			T t = list.get(index-1);
			getSession().save(t);
//			if(index%BATCH_OP_NUM == 0){
//				getSession().flush();
//			}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PK> T findById(Class<T> clazz,Long id){
		return (T)getSession().get(clazz, id);
	}
	
	public <T extends PK> void delete(T model){
		getSession().delete(model);
	}
	
	public Integer getSequence(String seqName){
		Long l = (Long)getSession().createSQLQuery("select seq.nextval from dual").uniqueResult();
		return null;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
