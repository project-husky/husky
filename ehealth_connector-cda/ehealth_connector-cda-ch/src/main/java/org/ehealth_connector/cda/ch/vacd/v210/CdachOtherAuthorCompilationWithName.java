/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.vacd.v210;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.48 Template
 * description: Reusable template wherever an author with required name is used
 * in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats
 * MAY use this template by either reference or specialisation.
 */
public class CdachOtherAuthorCompilationWithName
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Author {

	public CdachOtherAuthorCompilationWithName() {
	}

	/**
	 * Creates fixed contents for CDA Element hl7FunctionCode
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7FunctionCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		return retVal;
	}

	/**
	 * Gets the hl7AssignedAuthor
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor getHl7AssignedAuthor() {
		return assignedAuthor;
	}

	/**
	 * Gets the hl7FunctionCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7FunctionCode() {
		return functionCode;
	}

	/**
	 * Gets the hl7Time Timestamp of the authorship.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return time;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CE, filled by:
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CE getPredefinedFunctionCode() {
		return createHl7FunctionCodeFixedValue();
	}

	/**
	 * Sets the hl7AssignedAuthor
	 */
	public void setHl7AssignedAuthor(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor value) {
		this.assignedAuthor = value;
	}

	/**
	 * Sets the hl7FunctionCode
	 */
	public void setHl7FunctionCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.functionCode = value;
	}

	/**
	 * Sets the hl7Time Timestamp of the authorship.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.time = value;
	}
}
