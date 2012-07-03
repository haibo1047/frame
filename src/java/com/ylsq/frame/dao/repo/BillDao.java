/**
 * 
 */
package com.ylsq.frame.dao.repo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.ylsq.frame.dao.common.CommonDao;
import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.model.repo.Bill;
import com.ylsq.frame.model.repo.BillDetail;

/**
 * @author hopper
 *
 */
@Repository
public class BillDao extends CommonDao{
	public String genBillNo(BillType billType){
		String no = (String)getSession().createQuery("SELECT max(billNo) from Bill where billType=?").setParameter(0, billType).uniqueResult();
		no = StringUtils.defaultIfEmpty(no, billType.getPrefix()+"0");
		
		if(!no.startsWith(billType.getPrefix())){
			throw new RuntimeException("单据号异常["+no+"]，单据号应该以"+billType.getPrefix()+"开头");
		}
		no = no.substring(billType.getPrefix().length());
		if(StringUtils.isNumeric(no)){
			no = String.valueOf(Long.parseLong(no)+1);
		}
		return billType.getPrefix()+StringUtils.leftPad(no, 16,"0");
	}
	public List<Bill> findListByType(BillType billType){
		return getSession().createQuery("from Bill where billType=:billType").setParameter("billType", billType).list();
	}
	
	public Bill findById(Long billId){
		String sql = "select o,o.billDetail from Bill o where o.id = ?";
		Bill bill = (Bill)getSession().createQuery(sql).setParameter(0, billId).uniqueResult();
		return bill;
	}
	
	public List<BillDetail> findDetailListByBillId(Long billId){
		return getSession().createQuery("from BillDetail bd where bd.bill.id=?").setParameter(0, billId).list();
	}
}
