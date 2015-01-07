package org.ehc.cda;

/**
 * Common code for all text builder classes.
 * 
 * @author gsc
 */
abstract class TextBuilder {
	private StringBuffer buffer = new StringBuffer();

	TextBuilder() {
	}
	
	protected void append(String text) {
		buffer.append(text);
	}
	
	@Override
	public String toString() {
		return buffer.toString();
	}
	
}
