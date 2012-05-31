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
@Table(name = "SECU_MENU")
public class SecuMenu extends PK{
	private String menuName;
	private String menuPath;
	private String menuUrl;
	private String menuOrder;
	private Set<SecuRoleMenu> roleMenuSet;
	
	@Column(name="MENU_NAME")
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	@Column(name = "MENU_PATH")
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	
	@Column(name = "MENU_URL")
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	@Column(name = "MENU_ORDER")
	public String getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}
	
	@OneToMany(targetEntity = SecuRoleMenu.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name = "MENU_ID")
	public Set<SecuRoleMenu> getRoleMenuSet() {
		return roleMenuSet;
	}
	public void setRoleMenuSet(Set<SecuRoleMenu> roleMenuSet) {
		this.roleMenuSet = roleMenuSet;
	}
}
