/**
 * 
 */
package com.ylsq.frame.sh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.ylsq.frame.model.common.SecuMenu;
import com.ylsq.frame.model.common.SecuRole;
import com.ylsq.frame.service.common.SecuMenuService;
import com.ylsq.frame.service.common.SecuRoleMenuService;

/**
 * @author hopper
 *
 */
@Component("frameFilterInvocationSecurityMetadataSource")
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private static Logger logger = LoggerFactory.getLogger(CustomFilterInvocationSecurityMetadataSource.class);
	@Resource
	private SecuMenuService secuMenuService;
	@Resource
	private SecuRoleMenuService secuRoleMenuService;
	private boolean stripQueryStringFromUrls = true;
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException {
		if ((object == null) || !this.supports(object.getClass())) {
			throw new IllegalArgumentException("Object must be a FilterInvocation");
		}

		String url = ((FilterInvocation) object).getRequestUrl();
		if (url.contains("/expose/")) {
			logger.debug("url with expose need not authorize");
			return null;
		}

		return lookupAttributes(url);
	}
	
	public final Collection<ConfigAttribute> lookupAttributes(String url) {
        if (stripQueryStringFromUrls) {
            // Strip anything after a question mark symbol, as per SEC-161. See also SEC-321
            int firstQuestionMarkIndex = url.indexOf("?");

            if (firstQuestionMarkIndex != -1) {
                url = url.substring(0, firstQuestionMarkIndex);
            }
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || auth.getPrincipal() == null){
        	return new ArrayList<ConfigAttribute>(0);
        }
        if("root".equals(auth.getName()))
        	return null;
        List<ConfigAttribute> configAttrList = null;
        SecuMenu menu = secuMenuService.findByUrl(url);
        if(menu != null){
        	configAttrList = new ArrayList<ConfigAttribute>();
        	List<SecuRole> roleList = secuRoleMenuService.findRoleListByMenuId(menu.getId());
        	for(SecuRole role : roleList){
        		configAttrList.add(new SecurityConfig(role.getAuthority()));
        	}
        }
        return configAttrList;
    }

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
}
