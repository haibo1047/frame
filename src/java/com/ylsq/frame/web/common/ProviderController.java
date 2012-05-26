/**
 * 
 */
package com.ylsq.frame.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.Provider;

/**
 * @author hopper
 *
 */
@Controller
@RequestMapping("/provider")
public class ProviderController extends CommonController<Provider>{

	@Override
	protected String dir() {
		return "provider";
	}

	@Override
	protected Class<Provider> getObjectClass() {
		return Provider.class;
	}

}
