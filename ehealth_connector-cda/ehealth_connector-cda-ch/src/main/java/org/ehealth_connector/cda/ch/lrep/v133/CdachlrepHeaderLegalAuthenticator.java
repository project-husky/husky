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

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.61 Template
 * description: Legal authenticator.
 *
 * Element description: Legal authenticator.
 */
public class CdachlrepHeaderLegalAuthenticator
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator {

	public CdachlrepHeaderLegalAuthenticator() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.61"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.5"));
		super.setSignatureCode(createHl7SignatureCodeFixedValue("S", "2.16.840.1.113883.1.11.10282",
				"ParticipationSignature", "signed"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7SignatureCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 * @param codeSystem
	 *            the desired fixed value for this argument.
	 * @param codeSystemName
	 *            the desired fixed value for this argument.
	 * @param displayName
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CS createHl7SignatureCodeFixedValue(
			String code, String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
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

	/**
	 * Gets the hl7AssignedEntity The GLN MUST be used to identify the legal
	 * authenticator (e.g., laboratory manager or responsible physician). All
	 * persons and organizations, MUST according to XD-LAB contain name, addr
	 * and telecom.
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
	 * Gets the hl7Time Date of the signature.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return time;
	}

	/**
	 * Sets the hl7AssignedEntity The GLN MUST be used to identify the legal
	 * authenticator (e.g., laboratory manager or responsible physician). All
	 * persons and organizations, MUST according to XD-LAB contain name, addr
	 * and telecom.
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
	 * Sets the hl7Time Date of the signature.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.time = value;
	}
}
