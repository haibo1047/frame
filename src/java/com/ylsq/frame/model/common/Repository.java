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

/**
 * @author hopper
 *
 */
@Entity
@Table(name="REPOSITORY")
public class Repository extends PK{

	private String repositoryName;
	private String repoAddress;
	private Set<DrugRepository> drugRepositorySet;
	
	@Column(name = "REPOSITORY_NAME")
	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	
	@Column(name="REPO_ADDRESS")
	public String getRepoAddress() {
		return repoAddress;
	}
	public void setRepoAddress(String repoAddress) {
		this.repoAddress = repoAddress;
	}
	
	@OneToMany(targetEntity = DrugRepository.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name = "REPOSITORY_ID")
	public Set<DrugRepository> getDrugRepositorySet() {
		return drugRepositorySet;
	}
	public void setDrugRepositorySet(Set<DrugRepository> drugRepositorySet) {
		this.drugRepositorySet = drugRepositorySet;
	}
}
