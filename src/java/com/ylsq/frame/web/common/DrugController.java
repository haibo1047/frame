/**
 * 
 */
package com.ylsq.frame.web.common;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.dict.common.DrugType;
import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.model.common.Provider;
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
	

	@Override
	protected void beforeSave() {
		object = (Drug)object;
		object.setSimpleSpell(StringHelper.getSimpleSpell(object.getDrugName()));
		object.setDrugType(DrugType.convert(object.getExtraInt()));
		if(object.getExtraLong() != null){
			Provider prov = commonService.findById(Provider.class, object.getExtraLong());
			object.setDrugProvider(prov);
		}
	}

	@Override
	protected void beforeEdit(Model model) {
		List<Provider> providers = commonService.findAll(Provider.class);
		model.addAttribute("providers", providers);
		model.addAttribute("drugTypes", DrugType.values());
		if(object.getDrugType() !=null){
			object.setExtraInt(object.getDrugType().getValue());
		}
		if(object.getDrugProvider() != null){
			object.setExtraLong(object.getDrugProvider().getId());
		}
	}
}
