/**
 * 
 */
package com.ylsq.frame.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping("/addRepository")
	public String addRepository(Model model){
		model.addAttribute("repo", new Repository());
		return "/repository/addRepository";
	}
	
	@RequestMapping("/saveRepository")
	public String saveRepository(@ModelAttribute("repo") Repository repository,Model model){
		commonService.saveOrUpdateModel(Repository.class,repository);
		return list(model);
	}
	
	@RequestMapping("/editRepository")
	public String editRepository(Model model,Long id){
		Repository repo = commonService.findById(Repository.class, id);
		model.addAttribute("repo", repo);
		return "/repository/addRepository";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model,Long id){
		Repository repository = new Repository();
		repository.setId(id);
		commonService.deleteModel(Repository.class, repository);
		return list(model);
	}
}
