/**
 * 
 */
package com.ylsq.frame.model.common;

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

import com.ylsq.frame.dict.common.DrugType;

/**
 * @author hopper
 *
 */
@Table(name="drug")
@Entity
public class Drug extends PK{
	private String drugName;
	private String simpleSpell;
	private DrugType drugType;
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
