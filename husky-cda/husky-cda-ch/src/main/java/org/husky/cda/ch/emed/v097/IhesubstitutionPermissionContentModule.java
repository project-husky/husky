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

import java.util.ArrayList;
import javax.annotation.processing.Generated;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.model.Code;

/**
 * IHESubstitutionPermissionContentModule
 *
 * Template description: <div>An act element, containing exactly one element describing the substitution permission.</div>
 *
 * Element description: 6.3.4.8 Substitution Permission Content Module
 *
 * <!-- @formatter:off -->
 * Identifier: 1.3.6.1.4.1.19376.1.9.1.3.9.1
 * Effective date: 2018-01-10 15:34:25
 * Version: 2017
 * Status: pending
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class IhesubstitutionPermissionContentModule
		extends org.husky.common.hl7cdar2.POCDMT000040Act {

	public IhesubstitutionPermissionContentModule() {
		super.setClassCode(org.husky.common.hl7cdar2.XActClassDocumentEntryAct.ACT);
		super.setMoodCode(org.husky.common.hl7cdar2.XDocumentActMood.DEF);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.9.1"));
		super.setCode(createHl7CodeFixedValue());
		vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
		statusCode = (new Code(CodeBaseType.builder().withCode("completed").build()))
				.getHl7CdaR2Cs();
	}

	private ArrayList<org.husky.common.model.Code> vocabStatusCodeCode = new ArrayList<org.husky.common.model.Code>();

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 */
	private static org.husky.common.hl7cdar2.CD createHl7CodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.CD retVal = factory.createCD();
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
	 * Gets the hl7Code 6.3.4.8.3.3 Substitution Permission code
	 */
	public org.husky.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7StatusCode 6.3.4.8.3.4 Substitution Permission statusCode
	 */
	public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7TemplateId 6.3.4.8.3.2 Substitution Permission Template ID
	 */
	public java.util.List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Returns a list of vocab codes as defined in the ART-DECOR model
	 */
	public ArrayList<org.husky.common.model.Code> getVocabStatusCodeCode() {
		return vocabStatusCodeCode;
	}

	/**
	 * Sets the hl7Code 6.3.4.8.3.3 Substitution Permission code
	 */
	public void setHl7Code(org.husky.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7StatusCode 6.3.4.8.3.4 Substitution Permission statusCode
	 */
	public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
		this.statusCode = value;
	}

	/**
	 * Sets the hl7TemplateId 6.3.4.8.3.2 Substitution Permission Template ID
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
