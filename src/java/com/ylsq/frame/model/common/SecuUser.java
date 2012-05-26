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
@Table(name = "SECU_USER")
public class SecuUser extends PK{
	private String loginName;
	private String realName;
	private String userPasswd;
	
	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Column(name = "REAL_NAME")
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Column(name = "USER_PASSWD")
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
}
