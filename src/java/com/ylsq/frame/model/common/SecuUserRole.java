/**
 * 
 */
package com.ylsq.frame.model.common;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author hopper
 *
 */

@Entity
@Table(name = "SECU_USER_ROLE")
public class SecuUserRole extends PK {
	private SecuUser secuUser;
	private SecuRole secuRole;
	
	@ManyToOne(targetEntity = SecuUser.class)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "USER_ID")
	public SecuUser getSecuUser() {
		return secuUser;
	}
	public void setSecuUser(SecuUser secuUser) {
		this.secuUser = secuUser;
	}
	
	@ManyToOne(targetEntity = SecuRole.class)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "ROLE_ID")
	public SecuRole getSecuRole() {
		return secuRole;
	}
	public void setSecuRole(SecuRole secuRole) {
		this.secuRole = secuRole;
	}
}
