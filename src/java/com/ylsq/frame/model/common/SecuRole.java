package com.ylsq.frame.model.common;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "SECU_ROLE")
public class SecuRole extends PK implements GrantedAuthority ,Serializable{
	private static final long serialVersionUID = -4111187614433134792L;
	private String roleName;
	private String roleDesc;
	private String authority;
	
	private Set<SecuUserRole> userRoleSet;
	private Set<SecuRoleMenu> roleMenuSet;
	
	private List<String> selected;
	private List<String> unselect;
	@Transient
	public List<String> getSelected() {
		return selected;
	}
	public void setSelected(List<String> selected) {
		this.selected = selected;
	}
	@Transient
	public List<String> getUnselect() {
		return unselect;
	}
	public void setUnselect(List<String> unselect) {
		this.unselect = unselect;
	}
	@Column(name = "ROLE_NAME" ,length=30)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column(name = "ROLE_DESC",length = 500)
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Column(name = "AUTHORITY",length = 20)
	@Override
	public String getAuthority() {
		return authority;
	}
	
	@OneToMany(targetEntity = SecuUserRole.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name = "ROLE_ID")
	public Set<SecuUserRole> getUserRoleSet() {
		return userRoleSet;
	}
	public void setUserRoleSet(Set<SecuUserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}
	
	@OneToMany(targetEntity = SecuRoleMenu.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name = "ROLE_ID")
	public Set<SecuRoleMenu> getRoleMenuSet() {
		return roleMenuSet;
	}
	public void setRoleMenuSet(Set<SecuRoleMenu> roleMenuSet) {
		this.roleMenuSet = roleMenuSet;
	}
}
