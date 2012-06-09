/**
 * 
 */
package com.ylsq.frame.dict.common;

import com.ylsq.frame.sh.LabelAndValue;

/**
 * @author hopper
 *
 */
public enum BillType implements LabelAndValue {
	STORAGE(1,"入库单","rk");
	
	BillType(int v,String l,String p){
		value = v;
		label = l;
		prefix = p;
	}
	public BillType convert(int v){
		for(BillType e : values()){
			if(e.getValue()==v){
				return e;
			}
		}
		return null;
	}
	
	private Integer value;
	private String label;
	private String prefix;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
