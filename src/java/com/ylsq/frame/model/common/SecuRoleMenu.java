/**
 * 
 */
package com.ylsq.frame.model.common;

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
@Table(name = "SECU_ROLE_MENU")
public class SecuRoleMenu extends PK {
	private SecuRole secuRole;
	private SecuMenu secuMenu;
	
	@ManyToOne(targetEntity = SecuRole.class)
	@JoinColumn(name = "ROLE_ID")
	@Cascade(value = {CascadeType.SAVE_UPDATE})
	public SecuRole getSecuRole() {
		return secuRole;
	}
	public void setSecuRole(SecuRole secuRole) {
		this.secuRole = secuRole;
	}
	
	@ManyToOne(targetEntity = SecuMenu.class)
	@JoinColumn(name = "MENU_ID")
	@Cascade(value = {CascadeType.SAVE_UPDATE})
	public SecuMenu getSecuMenu() {
		return secuMenu;
	}
	public void setSecuMenu(SecuMenu secuMenu) {
		this.secuMenu = secuMenu;
	}
}
