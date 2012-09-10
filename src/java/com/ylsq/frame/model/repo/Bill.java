/**
 * 
 */
package com.ylsq.frame.model.repo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.ylsq.frame.dict.common.BillType;
import com.ylsq.frame.dict.common.Options;
import com.ylsq.frame.model.common.PK;
import com.ylsq.frame.model.common.Provider;
import com.ylsq.frame.model.common.Repository;

/**
 * @author hopper
 *
 */

@Entity
@Table(name = "BILL")
public class Bill extends PK {
	private BillType billType;
	private String billNo;
	private Repository repository;
	private Provider provider;
	private String createUser;
	private Date createDate;
	private Options available;
	
	private Set<BillDetail> billDetailSet;
	
	private String repositoryString;
	private String providerString;
	
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
	
	@ManyToOne(targetEntity = Repository.class)
	@JoinColumn(name = "REPOSITORY_ID")
	public Repository getRepository() {
		return repository;
	}
	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	@ManyToOne(targetEntity = Provider.class)
	@JoinColumn(name = "PROVIDER_ID")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
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
	
	@Column(name = "AVAILABLE",length=1)
	@Type(type="com.ylsq.frame.sh.LabelAndValueType",parameters={@Parameter(name="enumClass",value="com.ylsq.frame.dict.common.Options")})
	public Options getAvailable() {
		return available;
	}
	public void setAvailable(Options available) {
		this.available = available;
	}
	
	@OneToMany(targetEntity = BillDetail.class)
	@Cascade(value = {CascadeType.DELETE,CascadeType.SAVE_UPDATE})
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name="BILL_ID",insertable=true,updatable=true)
	public Set<BillDetail> getBillDetailSet() {
		return billDetailSet;
	}
	public void setBillDetailSet(Set<BillDetail> billDetailSet) {
		this.billDetailSet = billDetailSet;
	}
	
	
	@Transient
	public String getRepositoryString() {
		return repositoryString;
	}
	public void setRepositoryString(String repositoryString) {
		this.repositoryString = repositoryString;
	}
	@Transient
	public String getProviderString() {
		return providerString;
	}
	public void setProviderString(String providerString) {
		this.providerString = providerString;
	}
}
