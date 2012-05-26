/**
 * 
 */
package com.ylsq.frame.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hopper
 *
 */
@Entity
@Table(name = "SECU_MENU")
public class SecuMenu extends PK implements Comparable<SecuMenu>{
	private String menuName;
	private String menuPath;
	private String menuUrl;
	private String menuOrder;
	
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
	
	@Override
	public int compareTo(SecuMenu o) {
		if(o == null)
			return 1;
		if(StringUtils.isNotEmpty(o.getMenuOrder())){
			if(StringUtils.isEmpty(getMenuOrder())){
				return -1;
			}
			String []srcArray = StringUtils.split(getMenuOrder(),"-");
			String []oArray = StringUtils.split(o.getMenuOrder(),"-");
			for(int index = 0; index<srcArray.length ;index++){
				if(index >= oArray.length){
					return 1;
				}
				int so = 0,oo = 0;
				if(StringUtils.isNumeric(srcArray[index])){
					so = Integer.parseInt(srcArray[index]);
				}
				if(StringUtils.isNumeric(oArray[index])){
					oo = Integer.parseInt(oArray[index]);
				}
				if(so != oo){
					return so - oo;
				}
			}
			if(oArray.length>srcArray.length){
				return -1;
			}
		}
		else if(StringUtils.isNotBlank(o.getMenuOrder())){
			return -1;
		}
		
		return getMenuPath().compareTo(o.getMenuPath());
	}
}
