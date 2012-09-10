/**
 * 
 */
package com.ylsq.frame.dict.common;

import com.ylsq.frame.sh.LabelAndValue;

/**
 * @author ylsq
 *
 */
public enum WarehouseType implements LabelAndValue{
	IN(1,"入库"),
	OUT(0,"出库");
	
	WarehouseType(int v,String l){
		value = v;
		label = l;
	}
	private Integer value;
	private String label;
	
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
	
}
