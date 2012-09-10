/**
 * 
 */
package com.ylsq.frame.service.repo;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ylsq.frame.dao.repo.BillDao;
import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.dict.common.Options;
import com.ylsq.frame.dict.common.WarehouseType;
import com.ylsq.frame.model.common.DrugRepository;
import com.ylsq.frame.model.repo.Bill;
import com.ylsq.frame.model.repo.BillDetail;
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
	
	public Bill createBill(Bill bill){
		bill.setCreateDate(new Date());
		bill.setBillNo(genBillNo(bill.getBillType()));
		bill.setAvailable(Options.NO);
		saveOrUpdateModel(Bill.class, bill);
		return bill;
	}
	
	public Bill findById(Long billId){
		return billDao.findById(billId);
	}
	
	public List<BillDetail> findDetailListByBillId(Long billId){
		return billDao.findDetailListByBillId(billId);
	}
	
	public boolean confirm(Bill bill,WarehouseType type){
		bill.setAvailable(Options.YES);
		if(WarehouseType.IN == type){
			Iterator<BillDetail> bdIt = bill.getBillDetailSet().iterator();
			while(bdIt.hasNext()){
				BillDetail bd = bdIt.next();
				DrugRepository dp = new DrugRepository();
				dp.setDrug(bd.getDrug());
//				dp.setRepository(repository)
			}
		}
		return true;
	}
}
