/**
 * 
 */
package com.ylsq.frame.web.repo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hopper
 *
 */
@Controller
@RequestMapping("repo")
public class RepositoryManageController {

	@RequestMapping("pandian")
	public String pandian(Model model){
		return "/repo/bill";
	}
	
	@RequestMapping("ac")
	public String ac(){
		return "/repo/ac";
	}
}
