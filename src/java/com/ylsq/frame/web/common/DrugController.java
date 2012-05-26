/**
 * 
 */
package com.ylsq.frame.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.utils.StringHelper;

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

	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute(new Drug());
		return "drug/editDrug";
	}
	
	@RequestMapping("/edit")
	public String edit(Long id,Model model){
		Drug drug = commonService.findById(Drug.class, id);
		model.addAttribute(drug);
		return "drug/editDrug";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id,Model model){
		Drug drug = new Drug();
		drug.setId(id);
		commonService.deleteModel(Drug.class, drug);
		return list(model);
	}
	
	@RequestMapping("save")
	public String saveDrug(@ModelAttribute("drug") Drug drug,Model model){
		drug.setSimpleSpell(StringHelper.getSimpleSpell(drug.getDrugName()));
		
		commonService.saveOrUpdateModel(Drug.class,drug);
		return list(model);
	}
}
