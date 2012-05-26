/**
 * 
 */
package com.ylsq.frame.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.Drug;

/**
 * @author hopper
 *
 */

@Controller
@RequestMapping("drug")
public class DrugController extends CommonController<Drug>{
	
	@Override
	protected String dir() {
		return "drug";
	}

	@Override
	protected Class<Drug> getObjectClass() {
		return Drug.class;
	}
}
