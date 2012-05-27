/**
 * 
 */
package com.ylsq.frame.dict.common;

import com.ylsq.frame.sh.LabelAndValue;

/**
 * @author hopper
 *	
 */
public enum DrugType implements LabelAndValue{
	OTC(1,"OTX"),
	RX(2,"处方药");
	private Integer value;
	private String label;
	
	public static DrugType convert(String l){
		for(DrugType dt : values()){
			if(dt.getLabel().equals(l))
				return dt;
		}
		return null;
	}
	
	public static DrugType convert(int v){
		for(DrugType dt : values()){
			if(v == dt.getValue())
				return dt;
		}
		return null;
	}
	DrugType(int v,String l){
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
