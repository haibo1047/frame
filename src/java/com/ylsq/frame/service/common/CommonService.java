/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.common.CommonDao;
import com.ylsq.frame.model.common.PK;

/**
 * @author hopper
 *
 */

@Service("commonService")
public class CommonService{
	@Autowired
	@Qualifier("commonDao")
	private CommonDao commonDao;
	
	public <T extends PK> List<T> find(Class<T> clazz,T example){
		return commonDao.find(clazz, example);
	}
	public <T extends PK> List<T> findAll(Class<T> clazz){
		return commonDao.findAll(clazz);
	}
	
	public <T extends PK> void saveOrUpdateModel(Class<T> clazz,T model){
		commonDao.saveOrUpdateModel(clazz,model);
	}
	
	public <T extends PK> void deleteModel(Class<T> clazz,T model){
		commonDao.delete(model);
	}
	
	public <T extends PK> T findById(Class<T> clazz,Long id){
		return commonDao.findById(clazz, id);
	}
	
	public <T extends PK> boolean saveAll(Class<T> clazz,List<T> list){
		return commonDao.saveAll(clazz, list);
	}
}
