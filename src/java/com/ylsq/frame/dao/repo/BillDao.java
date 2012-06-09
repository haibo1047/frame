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

/**
 * @author hopper
 *
 */
@Repository
public class BillDao extends CommonDao{
	public String genBillNo(BillType billType){
		String no = (String)getSession().createQuery("SELECT max(billNo) from Bill where billType=?").setParameter(0, billType).uniqueResult();
		
		if(StringUtils.isEmpty(no) || !no.startsWith(billType.getPrefix())){
			throw new RuntimeException("单据号异常["+no+"]，单据号应该以"+billType.getPrefix()+"开头");
		}
		no = no.substring(billType.getPrefix().length());
		if(StringUtils.isNumeric(no)){
			no = String.valueOf(Long.parseLong(no)+1);
		}
		return billType.getPrefix()+StringUtils.leftPad(no, 18,"0");
	}
	public List<Bill> findListByType(BillType billType){
		return getSession().createQuery("from Bill where billType=:billType").setParameter("billType", billType).list();
	}
}
