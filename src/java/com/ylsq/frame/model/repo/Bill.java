/**
 * 
 */
package com.ylsq.frame.model.repo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.model.common.PK;

/**
 * @author hopper
 *
 */

@Entity
@Table(name = "BILL")
public class Bill extends PK {
	private BillType billType;
	private String billNo;
	private String createUser;
	private Date createDate;
	
	private Set<BillDetail> billDetailSet;
	
	@Column(name = "BILL_TYPE")
	@Type(type="com.ylsq.frame.sh.LabelAndValueType",parameters={@Parameter(name="enumClass",value="com.ylsq.frame.dict.common.BillType")})
	public BillType getBillType() {
		return billType;
	}
	public void setBillType(BillType billType) {
		this.billType = billType;
	}
	
	@Column(name = "BILL_NO",length = 18)
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	@Column(name = "CREATE_USER")
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@OneToMany(targetEntity = BillDetail.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(insertable=true,updatable=true)
	public Set<BillDetail> getBillDetailSet() {
		return billDetailSet;
	}
	public void setBillDetailSet(Set<BillDetail> billDetailSet) {
		this.billDetailSet = billDetailSet;
	}
}
