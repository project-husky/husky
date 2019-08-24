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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

import java.util.ArrayList;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.16
 * Template description: Reusable template wherever an author with required name, addr and telecom is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 */
public class CdachOtherAuthorCompilationWithNameAddrTelecom extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Author {

	public CdachOtherAuthorCompilationWithNameAddrTelecom() {
		super.setFunctionCode(createHl7FunctionCodeFixedValue("NAV", "2.16.840.1.113883.6.96", "SNOMED CT"));
	// cdach_other_AuthorCompilationWithNameAddrTelecom/hl7:functionCode:cs valueSet = valueSet("2.16.756.5.30.1.127.3.10.1.1.3"); --> org.ehealth_connector.cda.ch.lrep.v133.enums.DocumentEntryAuthorRole
	// cdach_other_AuthorCompilationWithNameAddrTelecom/hl7:functionCode:st nullFlavor = "NAV";
	// cdach_other_AuthorCompilationWithNameAddrTelecom/hl7:functionCode:oid codeSystem = "2.16.840.1.113883.6.96";
	// cdach_other_AuthorCompilationWithNameAddrTelecom/hl7:functionCode:st codeSystemName = "SNOMED CT";
	}

	/**
	 * Creates fixed contents for CDA Element hl7FunctionCode
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7FunctionCodeFixedValue(String nullFlavor, String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
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
	 * The functionCode MUST be taken from the Swiss EPR Value-Set for author roles. See FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3: Metadata, Section 2.1.If the desired functionCode is not available in the Swiss EPR Value-Set for author roles, nullFlavor='NAV' MUST be used. In this case, the originalText element MUST contain the description of the role.Translations to other vocabularies are allowed.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7FunctionCode() {
		return functionCode;
	}

	/**
	 * Gets the hl7Time
	 * Timestamp of the authorship.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return time;
	}

	/**
	 * Sets the hl7AssignedAuthor
	 */
	public void setHl7AssignedAuthor(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor value) {
		this.assignedAuthor = value;
	}

	/**
	 * Sets the hl7FunctionCode
	 * The functionCode MUST be taken from the Swiss EPR Value-Set for author roles. See FDHA Ordinance on the Electronic Patient Record (EPRO-FDHA), Appendix 3: Metadata, Section 2.1.If the desired functionCode is not available in the Swiss EPR Value-Set for author roles, nullFlavor='NAV' MUST be used. In this case, the originalText element MUST contain the description of the role.Translations to other vocabularies are allowed.
	 */
	public void setHl7FunctionCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.functionCode = value;
	}

	/**
	 * Sets the hl7Time
	 * Timestamp of the authorship.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.time = value;
	}
}
