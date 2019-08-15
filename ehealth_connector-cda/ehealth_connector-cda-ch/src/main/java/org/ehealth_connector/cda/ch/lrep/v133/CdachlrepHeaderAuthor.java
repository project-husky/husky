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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.59
 * Template description: Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
 *
 * Element description: Information about the author of the document. The author MAY be a person or a device. At least one author MUST be declared.
 */
public class CdachlrepHeaderAuthor extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Author {

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
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getTemplateId() != null)
			if (getTemplateId().size() > 0)
				retVal = getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Time
	 * Date and time of the laboratory report creation.
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
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Time
	 * Date and time of the laboratory report creation.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.time = value;
	}
}
