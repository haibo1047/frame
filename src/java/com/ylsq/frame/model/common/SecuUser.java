/**
 * 
 */
package com.ylsq.frame.model.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author hopper
 *
 */

@Entity
@Table(name = "SECU_USER")
public class SecuUser extends PK implements UserDetails,Serializable{
	private static final long serialVersionUID = -7254628177488321565L;
	private String username;
	private String realName;
	private String password;
	private Set<SecuUserRole> userRoleSet;
	
	@Column(name = "USERNAME")
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "PASSWORD")
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "REAL_NAME")
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@OneToMany(targetEntity = SecuUserRole.class)
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name = "USER_ID")
	public Set<SecuUserRole> getUserRoleSet() {
		return userRoleSet;
	}
	public void setUserRoleSet(Set<SecuUserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}
	
	@Transient
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		if(userRoleSet == null){
			return new ArrayList<GrantedAuthority>(0);
		}
		List<SecuRole> roles = new ArrayList<SecuRole>();
		for(SecuUserRole sur : userRoleSet){
			roles.add(sur.getSecuRole());
		}
		return new ArrayList<GrantedAuthority>(roles);
	}
	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}
}
