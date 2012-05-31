/**
 * 
 */
package com.ylsq.frame.sh;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ylsq.frame.model.common.SecuUser;
import com.ylsq.frame.model.common.SecuUserRole;
import com.ylsq.frame.service.common.CommonService;
import com.ylsq.frame.service.common.SecuUserRoleService;

/**
 * @author hopper
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Resource
	private CommonService commonService;
	@Resource
	private SecuUserRoleService seuUserRoleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecuUser secuUser = new SecuUser();
		secuUser.setUsername(username);
		List<SecuUser> list = commonService.find(SecuUser.class, secuUser);
		if(list.size() == 1){
			secuUser = list.get(0);
			List<SecuUserRole> urList = seuUserRoleService.findListByUserId(secuUser.getId());
			secuUser.setUserRoleSet(new HashSet<SecuUserRole>(urList));
			return secuUser;
		}
		return null;
	}
}
