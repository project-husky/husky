package org.ehc.cda;

import java.util.Date;

import org.ehc.common.Value;

/**
 * Serologie holds attributes to store in CDA "Serologie Studies" section.
 * 
 * @author gsc
 */
public class Serologie {
	private Value value;
	private Date date;
	
	/**
	 * Constructor.
	 * 
	 * @param value
	 * @param date
	 */
	public Serologie(Value value, Date date) {
		super();
		this.value = value;
		this.date = date;
	}

	public Value getValue() {
		return value;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Serologie [value=" + value + ", date=" + date + "]";
	}
	
	
}
