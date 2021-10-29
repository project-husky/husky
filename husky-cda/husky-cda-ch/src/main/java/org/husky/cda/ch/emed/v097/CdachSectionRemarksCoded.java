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
package org.husky.cda.ch.emed.v097;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;

/**
 * cdach_section_RemarksCoded
 *
 * Template description: This section MAY be used to provide comments, remarks or other information that cannot be declared in any of the other existing sections in the document.
 *
 * Element description: This section can be used to provide comments, remarks or other information that cannot be declared in any of the other existing sections in the document.
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.756.5.30.1.1.10.3.2
 * Effective date: 2018-04-18 00:00:00
 * Version: 2017
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class CdachSectionRemarksCoded
		extends org.husky.common.hl7cdar2.POCDMT000040Section {

	public CdachSectionRemarksCoded() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.2"));
		super.setCode(createHl7CodeFixedValue("48767-8", "2.16.840.1.113883.6.1", "LOINC",
				"Annotation comment"));
	}

	/**
	 * Adds a hl7Entry
	 */
	public void addHl7Entry(org.husky.common.hl7cdar2.POCDMT000040Entry value) {
		getEntry().add(value);
	}

	/**
	 * Adds a hl7Entry
	 */
	public void clearHl7Entry() {
		getEntry().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
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
	private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue(String code,
			String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.CE retVal = factory.createCE();
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
	private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 */
	public org.husky.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Id An ID for this section MAY be filled for traceability.
	 */
	public org.husky.common.hl7cdar2.II getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text Human readable text of this section.
	 */
	public org.husky.common.hl7cdar2.StrucDocText getHl7Text() {
		return text;
	}

	/**
	 * Gets the hl7Title Fixed human readable title of this section. - [ge]:
	 * 'Kommentar' - [fr]: 'Commentaire' - [it]: 'Osservazione' - [en]:
	 * 'Comment'
	 */
	public org.husky.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Id An ID for this section MAY be filled for traceability.
	 */
	public void setHl7Id(org.husky.common.hl7cdar2.II value) {
		this.id = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text Human readable text of this section.
	 */
	public void setHl7Text(org.husky.common.hl7cdar2.StrucDocText value) {
		this.text = value;
	}

	/**
	 * Sets the hl7Title Fixed human readable title of this section. - [ge]:
	 * 'Kommentar' - [fr]: 'Commentaire' - [it]: 'Osservazione' - [en]:
	 * 'Comment'
	 */
	public void setHl7Title(org.husky.common.hl7cdar2.ST value) {
		this.title = value;
	}
}
