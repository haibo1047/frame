/**
 * 
 */
package com.ylsq.frame.service.repo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.repo.BillDao;
import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.model.repo.Bill;
import com.ylsq.frame.service.common.CommonService;

/**
 * @author hopper
 *
 */
@Service
public class BillService extends CommonService {
	@Resource
	private BillDao billDao;
	
	public String genBillNo(BillType billType){
		return billDao.genBillNo(billType);
	}
	
	public List<Bill> findListByType(BillType billType){
		return billDao.findListByType(billType);
	}
	
	public Bill createBill(BillType billType,String createUser){
		Bill bill = new Bill();
		bill.setBillType(billType);
		bill.setCreateDate(new Date());
		bill.setCreateUser(createUser);
		bill.setBillNo(genBillNo(billType));
		saveOrUpdateModel(Bill.class, bill);
		return bill;
	}
}
