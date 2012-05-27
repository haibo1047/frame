/**
 * 
 */
package com.ylsq.frame.web.common;

import java.io.OutputStream;
import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	protected CommonService commonService;
	
	protected T object;
	protected List<T> objectList;
	private String exportFilePath;

	abstract protected String dir();
	abstract protected Class<T> getObjectClass();
	
	public void customList(){
		objectList = (List<T>)commonService.findAll(getObjectClass());
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		customList();
		model.addAttribute("objectList", objectList);
		return getListPath();
	}
	
	@RequestMapping("/add")
	public String add(Model model){
		object = BeanUtils.instantiate(getObjectClass());
		beforeEdit(model);
		model.addAttribute("object", object);
		objectDir(model);
		return getEditPath();
	}
	
	@RequestMapping("/edit")
	public String edit(Long id,Model model){
		object = commonService.findById(getObjectClass(), id);
		beforeEdit(model);
		model.addAttribute("object", object);
		objectDir(model);
		return getEditPath();
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
	
	protected String getListPath(){
		return dir()+"/list"+StringHelper.firstCharUpper(dir());
	}
	
	protected String getEditPath(){
		return dir()+"/edit"+StringHelper.firstCharUpper(dir());
	}
	
	protected void objectDir(Model model){
		model.addAttribute("objectDir", dir());
	}
	
	public String getExportFilePath() {
		return exportFilePath;
	}
	public void setExportFilePath(String exportFilePath) {
		this.exportFilePath = exportFilePath;
	}
	protected void beforeSave(){}
	
	protected void beforeEdit(Model model){}
	
	public void exportFile(HttpServletResponse response,HSSFWorkbook book){
		OutputStream os;
		try {
			response.setHeader("Content-Disposition", "attachment; filename=temp.xls");
			os = response.getOutputStream();
			book.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			logger.error("",e);
		}
	}
}
