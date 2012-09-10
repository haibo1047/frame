/**
 * 
 */
package com.ylsq.frame.web.repo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.model.common.Provider;
import com.ylsq.frame.model.common.Repository;
import com.ylsq.frame.model.repo.Bill;
import com.ylsq.frame.model.repo.BillDetail;
import com.ylsq.frame.service.common.CommonService;
import com.ylsq.frame.service.repo.BillService;
import com.ylsq.frame.utils.DateHelper;
import com.ylsq.frame.utils.SecurityUtils;

/**
 * @author hopper
 *
 */
@Controller
@RequestMapping("repo")
public class RepositoryManageController{
	private static Logger logger = LoggerFactory.getLogger(RepositoryManageController.class);
	@Autowired
	private BillService billService;
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("storage")
	public String storage(Model model){
		List<Bill> billList = billService.findListByType(BillType.STORAGE);
		model.addAttribute("billList", billList);
		return "repo/storageList";
	}
	
	@RequestMapping("addBill")
	public String addBill(Model model){
		Bill bill = new Bill();
		
		bill.setBillType(BillType.STORAGE);
		model.addAttribute("bill", bill);
		model.addAttribute("providerList", billService.findAll(Provider.class));
		model.addAttribute("repositoryList", commonService.findAll(Repository.class));
		return "repo/editBill";
	}
	
	@RequestMapping("saveBill")
	public String saveBill(@ModelAttribute Bill bill,Model model){
		logger.debug(bill.getBillType()+"===");
		bill.setCreateDate(new Date());
		bill.setCreateUser(SecurityUtils.fetchUsername());
		Provider provider = new Provider();
		provider.setId(Long.parseLong(bill.getProviderString()));
		Repository repository = new Repository();
		repository.setId(Long.parseLong(bill.getRepositoryString()));
		bill.setProvider(provider);
		bill.setRepository(repository);
		billService.createBill(bill);
		return storage(model);
	}
	
	@RequestMapping("editBillDetail")
	public String editBillDetail(Long id,Model model){
		Bill bill = billService.findById(Bill.class,id);
		logger.debug(bill.getBillNo());
		Set<BillDetail> details = new TreeSet<BillDetail>(billService.findDetailListByBillId(id));
		bill.setBillDetailSet(details);
		model.addAttribute("providerList", billService.findAll(Provider.class));
		model.addAttribute("bill", bill);
		return "repo/editBillDetail";
	}
	
	@RequestMapping("delete")
	public String delete(Long id,Model model){
		Bill bill = new Bill();
		bill.setId(id);
		billService.deleteModel(Bill.class, bill);
		return storage(model);
	}
	
	@RequestMapping("save")
	public String save(Long id,Model model,HttpServletRequest request){
		Bill bill = billService.findById(Bill.class,id);
		String[] detailIds = request.getParameterValues("detailId");
		String[] drugIds = request.getParameterValues("drugId");
		String[] providers = request.getParameterValues("createUser");
		String[] productDates = request.getParameterValues("productDate");
		String[] drugCounts = request.getParameterValues("drugCount");
		Set<BillDetail> billDetailSet = new HashSet<BillDetail>();
		bill.setBillDetailSet(billDetailSet);
		for(int index =1;index<providers.length;index++){
			String sp = providers[index];
			String sd = drugIds[index];
			String pd = productDates[index];
			String dc = drugCounts[index];
			Date date = DateHelper.parseDate(pd);
			if(StringUtils.isNumeric(sp) && StringUtils.isNumeric(sd) && StringUtils.isNumeric(dc) && date!=null){
				Provider provider = new Provider();
				provider.setId(Long.parseLong(sp));
				Drug drug = new Drug();
				drug.setId(Long.parseLong(sd));
				BillDetail detail = new BillDetail();
				if(StringUtils.isNotBlank(detailIds[index]) && StringUtils.isNumeric(detailIds[index])){
					detail.setId(Long.parseLong(detailIds[index]));
				}
				detail.setProvider(provider);
				detail.setDrug(drug);
				detail.setDrugCount(Integer.parseInt(dc));
				detail.setProductDate(date);
				detail.setBill(bill);
				billDetailSet.add(detail);
			}
		}
		billService.saveOrUpdateModel(Bill.class, bill);
		return editBillDetail(id, model);
	}
	
	@RequestMapping("confirmBill")
	public String confirmBill(Long billId,Model model,HttpServletRequest request){
		String id = request.getParameter("id");
		Bill bill = billService.findById(Bill.class,Long.parseLong(id));
		logger.debug(id);
		return storage(model);
	}
}
