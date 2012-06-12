/**
 * 
 */
package com.ylsq.frame.web.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.model.repo.Bill;
import com.ylsq.frame.service.repo.BillService;
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

	@RequestMapping("storage")
	public String storage(Model model){
		List<Bill> billList = billService.findListByType(BillType.STORAGE);
		model.addAttribute("billList", billList);
		return "repo/storageList";
	}
	
	@RequestMapping("addBill")
	public String addBill(Model model){
		Bill bill = billService.createBill(BillType.STORAGE, SecurityUtils.fetchUsername());
		model.addAttribute("bill", bill);
		return "repo/editBill";
	}
	
	@RequestMapping("editBill")
	public String editBill(Long id,Model model){
		Bill bill = billService.findById(Bill.class, id);
		
		model.addAttribute("bill", bill);
		return "repo/editBill";
	}
	
	@RequestMapping("delete")
	public String delete(Long id,Model model){
		Bill bill = new Bill();
		bill.setId(id);
		billService.deleteModel(Bill.class, bill);
		return storage(model);
	}
}
