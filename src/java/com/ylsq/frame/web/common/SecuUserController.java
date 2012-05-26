package com.ylsq.frame.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.SecuUser;
import com.ylsq.frame.utils.StringHelper;


@Controller
@RequestMapping("user")
public class SecuUserController extends CommonController<SecuUser>{
	private static Logger logger = LoggerFactory.getLogger(SecuUserController.class);
	
	@Override
	protected String dir() {
		return "user";
	}

	@Override
	protected Class<SecuUser> getObjectClass() {
		return SecuUser.class;
	}

	@RequestMapping("/add")
	public String addUser(Model model){
		model.addAttribute("user",new SecuUser());
		return "user/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(Long id,Model model){
		SecuUser user = commonService.findById(SecuUser.class, id);
		model.addAttribute("user",user);
		return "user/userEdit";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id,Model model){
		SecuUser user = new SecuUser();
		user.setId(id);
		commonService.deleteModel(SecuUser.class, user);
		return list(model);
	}
	
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute SecuUser user,Model model){
		user.setUserPasswd(StringHelper.md5code(user.getUserPasswd()));
		commonService.saveOrUpdateModel(SecuUser.class, user);
		return list(model);
	}
}
