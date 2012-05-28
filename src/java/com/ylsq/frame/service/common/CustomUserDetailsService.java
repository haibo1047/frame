/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ylsq.frame.model.common.SecuUser;

/**
 * @author hopper
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Resource
	private CommonService commonService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecuUser secuUser = new SecuUser();
		secuUser.setLoginName(username);
		List<SecuUser> list = commonService.find(SecuUser.class, secuUser);
		if(list.size() == 1){
			secuUser = list.get(0);
			return new User(secuUser.getLoginName(),secuUser.getUserPasswd(),null);
		}
		return null;
	}
}
