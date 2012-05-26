/**
 * 
 */
package com.ylsq.frame.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author hopper
 *
 */
@Entity
@Table(name = "provider")
public class Provider extends PK{
	private String providerName;
	private String commonContact;
	private String providerTel;
	
	@Column(name = "PROVIDER_NAME")
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	@Column(name = "COMMON_CONTACT")
	public String getCommonContact() {
		return commonContact;
	}
	public void setCommonContact(String commonContact) {
		this.commonContact = commonContact;
	}
	
	@Column(name = "PROVIDER_TEL")
	public String getProviderTel() {
		return providerTel;
	}
	public void setProviderTel(String providerTel) {
		this.providerTel = providerTel;
	}
}
