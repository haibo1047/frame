/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.common.SecuMenuDao;
import com.ylsq.frame.model.common.SecuMenu;

/**
 * @author hopper
 *
 */
@Service
public class SecuMenuService extends CommonService {
	@Resource
	private SecuMenuDao secuMenuDao;
	public SecuMenu findByUrl(String url){
		SecuMenu m = new SecuMenu();
		m.setMenuUrl(url);
		List<SecuMenu> menuList = find(SecuMenu.class, m);
		if(menuList.size() == 1){
			return menuList.get(0);
		}
		return null;
	}
	
	public List<SecuMenu> findListByUsername(String loginName){
		return secuMenuDao.findListByUsername(loginName);
	}
}
