/**
 * 
 */
package com.ylsq.frame.model.repo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.model.common.PK;
import com.ylsq.frame.model.common.Provider;

/**
 * @author hopper
 *
 */

@Entity
@Table(name = "BILL_DETAIL")
public class BillDetail extends PK{
	private Bill bill;
	private Drug drug;
	private Provider provider;
	private Date productDate;
	private Integer drugCount;
	
	@ManyToOne(targetEntity = Bill.class)
	@JoinColumn(name = "BILL_ID")
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	@OneToOne
	@JoinColumn(name = "DRUG_ID")
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	@OneToOne
	@JoinColumn(name = "PROVIDER_ID")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	@Column(name = "PRODUCT_DATE")
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	
	@Column(name = "DRUG_COUNT",length = 8)
	public Integer getDrugCount() {
		return drugCount;
	}
	public void setDrugCount(Integer drugCount) {
		this.drugCount = drugCount;
	}
}
