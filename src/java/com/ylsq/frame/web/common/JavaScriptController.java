/**
 * 
 */
package com.ylsq.frame.web.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.service.common.CommonService;

/**
 * @author hopper
 *
 */

@Controller
@RequestMapping("js")
public class JavaScriptController {
	private static Logger logger = LoggerFactory.getLogger(JavaScriptController.class);
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("drug")
	public void drug(HttpServletResponse response){
		try{
			List<Drug> allDrug = commonService.findAll(Drug.class);
			StringBuffer drugInfo = new StringBuffer("var drugJsArray = [");
			for(int index=0;index<allDrug.size();index++){
				Drug drug = allDrug.get(index);
				if(index>0)
					drugInfo.append(",");
				drugInfo.append("{");
				drugInfo.append("value:'").append(drug.getId()).append("',");
				drugInfo.append("label:'").append(drug.getSimpleSpell())
										  .append("-").append(drug.getDrugName())
										  .append("-").append(drug.getDrugForm())
										  .append("-").append(drug.getApprovalNumber()==null?"":drug.getApprovalNumber())
										  .append("-").append(drug.getManufacturer()==null?"":drug.getManufacturer());
				drugInfo.append("',");
				drugInfo.append("name:'").append(drug.getDrugName()).append("',");
				drugInfo.append("}");
			}
			drugInfo.append("];");
			byte[] data = drugInfo.toString().getBytes("utf-8");
			response.setContentType("text/javascript;charset=utf-8");
            response.setContentLength(data.length);
			response.getOutputStream().write(data);
		}catch(IOException io){
			logger.warn("js error",io);
		}
	}
}
