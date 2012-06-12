/**
 * 
 */
package com.ylsq.frame.dict.common;

import com.ylsq.frame.sh.LabelAndValue;

/**
 * @author hopper
 *
 */
public enum Options implements LabelAndValue {
	YES(1,"是"),
	NO(0,"否");
	private Integer value;
	private String label;
	Options(int v,String l){
		value = v;
		label = l;
	}
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
