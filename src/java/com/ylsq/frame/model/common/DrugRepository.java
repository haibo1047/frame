/**
 * 
 */
package com.ylsq.frame.model.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * @author hopper
 *
 */
@Entity
@Table(name = "DRUG_REPOSITORY")
public class DrugRepository extends PK{
	private Drug drug;
	private Repository repository;
	private Double drugPrice;
	private Integer drugNumber;
	private String batchNum;
	private Date produceDate;

	@ManyToOne(targetEntity = Drug.class)
	@JoinColumn(name = "DRUG_ID")
	@Cascade(value = {CascadeType.SAVE_UPDATE})
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	@ManyToOne(targetEntity = Repository.class)
	@JoinColumn(name = "REPOSITORY_ID")
	@Cascade(value = {CascadeType.SAVE_UPDATE})
	public Repository getRepository() {
		return repository;
	}
	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	@Column(name = "DRUG_PRICE")
	public Double getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}
	
	@Column(name = "DRUG_NUMBER")
	public Integer getDrugNumber() {
		return drugNumber;
	}
	public void setDrugNumber(Integer drugNumber) {
		this.drugNumber = drugNumber;
	}
	
	@Column(name = "BATCH_NUM")
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	
	@Column(name = "PRODUCE_DATE")
	public Date getProduceDate() {
		return produceDate;
	}
	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}
}
