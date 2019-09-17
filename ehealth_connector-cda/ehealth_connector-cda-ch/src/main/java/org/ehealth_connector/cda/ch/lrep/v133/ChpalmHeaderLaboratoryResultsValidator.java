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
package org.ehealth_connector.cda.ch.lrep.v133;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.88 Template
 * description: The document MAY contain further signatures (besides the legal
 * authenticator). A Laboratory Results Validator is such an authenticator. It
 * is a laboratory specialist who has performed the clinical validation of the
 * entire document or a subset of the laboratory results. If this element is
 * specified, the following applies: - If only one laboratory specialist has
 * carried out the clinical validation of the document, it should be specified
 * in the header, only. - If multiple laboratory specialists were involved in
 * the clinical validation of the document, all must be specified in the header
 * and body (at entry, organizer or observation level, depending on the scope of
 * the results that the corresponding person has validated). - All persons and
 * organizations, MUST according to XD-LAB contain name, addr and telecom.
 *
 * Element description: Information about an authenticator of a CDA document. An
 * authenticator MUST be a person.
 */
public class ChpalmHeaderLaboratoryResultsValidator
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator {

	/**
	 * Creates fixed contents for CDA Element hl7SignatureCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CS createHl7SignatureCodeFixedValue(
			String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
		retVal.setCode(code);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	public ChpalmHeaderLaboratoryResultsValidator() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.88"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.6"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.5"));
		super.setSignatureCode(createHl7SignatureCodeFixedValue("S"));
	}

	/**
	 * Gets the hl7AssignedEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return assignedEntity;
	}

	/**
	 * Gets the hl7SignatureCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7SignatureCode() {
		return signatureCode;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Time Timestamp of the signature.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return time;
	}

	/**
	 * Sets the hl7AssignedEntity
	 */
	public void setHl7AssignedEntity(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		this.assignedEntity = value;
	}

	/**
	 * Sets the hl7SignatureCode
	 */
	public void setHl7SignatureCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.signatureCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Time Timestamp of the signature.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.time = value;
	}
}
