/**
 * 
 */
package com.ylsq.frame.model.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * @author hopper
 *
 */
@MappedSuperclass
public abstract class ExtraPK extends PK{
	private String extraString;
	private int extraInt;
	private Long extraLong;
	
	@Transient
	public int getExtraInt() {
		return extraInt;
	}
	public void setExtraInt(int extraInt) {
		this.extraInt = extraInt;
	}
	@Transient
	public Long getExtraLong() {
		return extraLong;
	}
	public void setExtraLong(Long extraLong) {
		this.extraLong = extraLong;
	}
	@Transient
	public String getExtraString() {
		return extraString;
	}
	public void setExtraString(String extraString) {
		this.extraString = extraString;
	}
}
