/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.validation.service.schematron;

import java.util.List;

/**
 * Exception indicating a failure to auto-detect the <cite>Schematron
 * Rule-Set</cite> to use for validating a particular document.
 * <p>
 * A detail message is automatically provided if the list of detected matching
 * rule-sets is specified and if this list is either empty or contains more than
 * one item.
 * </p>
 */
public class RuleSetDetectionException extends Exception {
	private static final long serialVersionUID = -386764676800665210L;

	private final List<RuleSet> ruleSetList;

	/**
	 * Constructs a new <tt>RuleSetDetectionException</tt> with the given list
	 * of detected matching rule-sets.
	 */
	public RuleSetDetectionException(List<RuleSet> ruleSetList) {
		this.ruleSetList = ruleSetList;
	}

	/**
	 * Constructs a new <tt>RuleSetDetectionException</tt> with the given error
	 * detail message.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public RuleSetDetectionException(String message) {
		super(message);
		this.ruleSetList = null;
	}

	/**
	 * Constructs a new <tt>RuleSetDetectionException</tt> with the given error
	 * detail message and the nested throwable cause.
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause leading this exception to be thrown.
	 */
	public RuleSetDetectionException(String message, Throwable cause) {
		super(message, cause);
		this.ruleSetList = null;
	}

	/**
	 * Constructs a new <tt>RuleSetDetectionException</tt> with the specified
	 * nested throwable cause and no detail message.
	 * 
	 * @param cause
	 *            the cause leading this exception to be thrown.
	 */
	public RuleSetDetectionException(Throwable cause) {
		super(cause);
		this.ruleSetList = null;
	}

	/**
	 * Returns the list of detected matching rule-sets.
	 *
	 * @return the list of detected matching rule-sets causing this exception.
	 */
	public List<RuleSet> getMatchingRuleSets() {
		return ruleSetList;
	}

	@Override
	public String getMessage() {
		String detailMessage = super.getMessage();
		if (detailMessage == null && ruleSetList != null) {
			if (ruleSetList.isEmpty()) {
				detailMessage = "No matching rule-set found for input document.";
			} else if (ruleSetList.size() > 1) {
				detailMessage = "Document matches more than one rule-set: " + ruleSetList;
			}
		}
		return detailMessage;
	}

}
