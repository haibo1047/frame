/**
 * 
 */
package com.ylsq.frame.model.common;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.ylsq.frame.dict.common.DrugType;

/**
 * @author hopper
 *
 */
@Table(name="drug")
@Entity
public class Drug extends ExtraPK{
	private String drugName;
	private String simpleSpell;
	private DrugType drugType;
	private String drugUnit;//单位
	private Integer guaranteeMonth;//保持期（月）
	private String approvalNumber;//批准文号
	private Provider drugProvider;//供应商
	private String productModel;//规格
	private String manufacturer;//生产厂商
	private Set<DrugRepository> drugRepositorySet;
	
	@Column(name="DRUG_NAME")
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	
	@Column(name = "SIMPLE_SPELL")
	public String getSimpleSpell() {
		return simpleSpell;
	}
	public void setSimpleSpell(String simpleSpell) {
		this.simpleSpell = simpleSpell;
	}
	
	@Column(name = "DRUG_TYPE")
	@Type(type="com.ylsq.frame.sh.LabelAndValueType",parameters={@Parameter(name="enumClass",value="com.ylsq.frame.dict.common.DrugType")})
	public DrugType getDrugType() {
		return drugType;
	}
	public void setDrugType(DrugType drugType) {
		this.drugType = drugType;
	}

	@Column(name = "DRUG_UNIT")
	public String getDrugUnit() {
		return drugUnit;
	}
	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}
	
	@Column(name = "GUARANTEE_MONTH")
	public Integer getGuaranteeMonth() {
		return guaranteeMonth;
	}
	public void setGuaranteeMonth(Integer guaranteeMonth) {
		this.guaranteeMonth = guaranteeMonth;
	}
	
	@Column(name = "APPROVAL_NUMBER")
	public String getApprovalNumber() {
		return approvalNumber;
	}
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	
	@Column(name = "PRODUCT_MODEL")
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	
	@Column(name = "MANUFACTURER")
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@ManyToOne(targetEntity=Provider.class)
	@Cascade(value = {CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "PROVIDER_ID")
	@Fetch(FetchMode.SELECT)
	public Provider getDrugProvider() {
		return drugProvider;
	}
	public void setDrugProvider(Provider drugProvider) {
		this.drugProvider = drugProvider;
	}
	
	@OneToMany(targetEntity = DrugRepository.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name = "DRUG_ID")
	public Set<DrugRepository> getDrugRepositorySet() {
		return drugRepositorySet;
	}
	public void setDrugRepositorySet(Set<DrugRepository> drugRepositorySet) {
		this.drugRepositorySet = drugRepositorySet;
	}
}
