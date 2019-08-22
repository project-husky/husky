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
package org.ehealth_connector.cda.ch.emed.v0953;

import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.50
 * Template description: A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.
 *
 * Element description: IHE PHARM PML document code
 */
public class DocumentCodeMedicationList extends org.ehealth_connector.common.hl7cdar2.CE {

	public DocumentCodeMedicationList() {
		super.setCode("721912009");
		super.getTranslation().add(createHl7TranslationFixedValue("721912009"));
	// Vocab not supported, yet. Should add a code:721912009 / 2.16.840.1.113883.6.96
	// DocumentCodeMedicationList/hl7:code:cs code = "721912009"; (isVocab)
	// Vocab not supported, yet. Should add a code:721912009 / 2.16.840.1.113883.6.96
	// DocumentCodeMedicationList/hl7:translation:cs code = "721912009"; (isVocab)
	}

	@XmlTransient()
	private String myCode;

	/**
	 * Creates fixed contents for CDA Attribute code
	 */
	private void createCodeFixedValue(String value) {
		this.myCode = value;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Translation
	 *
	 * @param code the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7TranslationFixedValue(String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		return retVal;
	}

	/**
	 * Gets the hl7Translation
	 * Translation to the Swiss EPR XDS.b metadata.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Translation() {
		org.ehealth_connector.common.hl7cdar2.CD retVal = null;
		if (getTranslation() != null)
			if (getTranslation().size() > 0)
				retVal = getTranslation().get(0);
		return retVal;
	}

	/**
	 * Gets the member myCode
	 */
	public String getPredefinedCode() {
		return myCode;
	}

	/**
	 * Sets the hl7Translation
	 * Translation to the Swiss EPR XDS.b metadata.
	 */
	public void setHl7Translation(org.ehealth_connector.common.hl7cdar2.CD value) {
		getTranslation().clear();
		getTranslation().add(value);
	}
}
