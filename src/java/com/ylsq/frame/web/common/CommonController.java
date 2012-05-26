/**
 * 
 */
package com.ylsq.frame.web.common;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.PK;
import com.ylsq.frame.service.common.CommonService;
import com.ylsq.frame.utils.StringHelper;

/**
 * @author hopper
 *
 */
@MappedSuperclass
public abstract class CommonController<T extends PK> {
	@Autowired
	protected CommonService commonService;
	
	protected T object;
	protected List<T> objectList;

	abstract protected String dir();
	abstract protected Class<T> getObjectClass();
	
	public void customList(){
		objectList = (List<T>)commonService.findAll(getObjectClass());
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		customList();
		model.addAttribute("objectList", objectList);
		return dir()+"/list"+StringHelper.firstCharUpper(dir());
	}
	
	@RequestMapping("/add")
	public String add(Model model){
		object = BeanUtils.instantiate(getObjectClass());
		beforeEdit(model);
		model.addAttribute("object", object);
		model.addAttribute("objectDir", dir());
		return dir()+"/edit"+StringHelper.firstCharUpper(dir());
	}
	
	@RequestMapping("/edit")
	public String edit(Long id,Model model){
		object = commonService.findById(getObjectClass(), id);
		beforeEdit(model);
		model.addAttribute("object", object);
		model.addAttribute("objectDir", dir());
		return dir()+"/edit"+StringHelper.firstCharUpper(dir());
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute T obj,Model model){
		object = obj;
		beforeSave();
		commonService.saveOrUpdateModel(getObjectClass(), object);
		return list(model);
	}
	
	@RequestMapping("/delete")
	public String delete(Long id,Model model){
		object = BeanUtils.instantiate(getObjectClass());
		object.setId(id);
		commonService.deleteModel(getObjectClass(), object);
		return list(model);
	}
	
	protected void beforeSave(){}
	
	protected void beforeEdit(Model model){}
}
