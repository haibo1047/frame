package com.ylsq.frame.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

	@Override
	protected void beforeSave() {
		object.setPassword(StringHelper.md5code(object.getPassword()));
		logger.debug("before");
	}

}
