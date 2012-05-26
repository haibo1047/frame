/**
 * 
 */
package com.ylsq.frame.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.model.common.DrugRepository;
import com.ylsq.frame.model.common.Repository;
import com.ylsq.frame.service.common.CommonService;

/**
 * @author hopper
 *
 */
@Controller
public class DrugRepositoryController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/dr/test")
	public void test(){
		Drug drug = new Drug();
		drug.setDrugName("一个");
		drug.setSimpleSpell("yy");
		
		Repository repository = new Repository();
		repository.setRepoAddress("address");
		repository.setRepositoryName("repoName");
		
		DrugRepository dr = new DrugRepository();
		dr.setDrug(drug);
		dr.setRepository(repository);
		dr.setDrugNumber(20);
		dr.setDrugPrice(10d);
		
		commonService.saveOrUpdateModel(DrugRepository.class,dr);
	}
}
