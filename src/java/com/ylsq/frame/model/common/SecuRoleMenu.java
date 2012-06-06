/**
 * 
 */
package com.ylsq.frame.model.common;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author hopper
 *
 */

@Entity
@Table(name = "SECU_ROLE_MENU")
public class SecuRoleMenu extends PK {
	private SecuRole secuRole;
	private SecuMenu secuMenu;
	
	@ManyToOne(targetEntity = SecuRole.class)
	@JoinColumn(name = "ROLE_ID")
	public SecuRole getSecuRole() {
		return secuRole;
	}
	public void setSecuRole(SecuRole secuRole) {
		this.secuRole = secuRole;
	}
	
	@ManyToOne(targetEntity = SecuMenu.class)
	@JoinColumn(name = "MENU_ID")
	public SecuMenu getSecuMenu() {
		return secuMenu;
	}
	public void setSecuMenu(SecuMenu secuMenu) {
		this.secuMenu = secuMenu;
	}
}
