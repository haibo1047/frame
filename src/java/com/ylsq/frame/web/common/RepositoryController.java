/**
 * 
 */
package com.ylsq.frame.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.Repository;

/**
 * @author hopper
 *
 */
@Controller
@RequestMapping("repository")
public class RepositoryController extends CommonController<Repository>{
	
	@Override
	protected String dir() {
		return "repository";
	}

	@Override
	protected Class<Repository> getObjectClass() {
		return Repository.class;
	}
}
