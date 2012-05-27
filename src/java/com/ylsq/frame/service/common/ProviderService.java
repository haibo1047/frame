/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ylsq.frame.model.common.Provider;

/**
 * @author hopper
 *
 */
@Service
public class ProviderService extends CommonService {
	public Provider findProviderByName(String providerName){
		Provider provider = new Provider();
		provider.setProviderName(providerName);
		List<Provider> list = find(Provider.class, provider);
		if(list.size() ==1){
			return list.get(0);
		}
		return null;
	}
}
