/**
 * 
 */
package com.ylsq.frame.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ylsq.frame.compare.SecuMenuComparator;
import com.ylsq.frame.model.common.SecuMenu;

/**
 * @author hopper
 *
 */
public class FrameMenu {
	private Long menuId;
	private String menuName;
	private String menuUrl;
	
	private FrameMenu parentMenu;
	private List<FrameMenu> subMenuList;
	private FrameMenu(){
	}
	public FrameMenu(String rootName,List<SecuMenu> menuList){
		Collections.sort(menuList, new SecuMenuComparator());
		menuName = StringUtils.defaultString(rootName, "root");
		for(SecuMenu m : menuList){
			FrameMenu previous = this;
			String[] s = StringUtils.split(m.getMenuPath(),"//");
			for(int index=0;index<s.length;index++){
				String sn = s[index];
				FrameMenu current = new FrameMenu();
				current.setMenuName(sn);
				current.setParentMenu(previous);
				if(index == s.length-1){
					current.setMenuId(m.getId());
					current.setMenuUrl(m.getMenuUrl());
				}
				else{
					current.setMenuUrl("#");
				}
				List<FrameMenu> sub = previous.getSubMenuList();
				if(sub == null){
					sub = new ArrayList<FrameMenu>();
					previous.setSubMenuList(sub);
				}
				boolean exist = false;
				for(FrameMenu subM : sub){
					if(subM.getMenuName().equals(sn)){
						exist = true;
						current = subM;
						break;
					}
				}
				if(!exist){
					sub.add(current);
				}
				previous = current;
			}
		}
	}
	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public FrameMenu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(FrameMenu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public List<FrameMenu> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<FrameMenu> subMenuList) {
		this.subMenuList = subMenuList;
	}
}
