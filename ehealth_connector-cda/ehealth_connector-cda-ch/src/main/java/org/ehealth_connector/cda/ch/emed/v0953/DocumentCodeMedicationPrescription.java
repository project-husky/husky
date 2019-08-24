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

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.52
 * Template description: A LOINC based document type of a CDA document instance including a translation to the Swiss EPR XDS.b metadata.
 *
 * Element description: IHE PHARM PRE document code
 */
public class DocumentCodeMedicationPrescription extends org.ehealth_connector.common.hl7cdar2.CE {

	public DocumentCodeMedicationPrescription() {
		super.setCode("440545006");
		super.getTranslation().add(createHl7TranslationFixedValue("440545006"));
	// DocumentCodeMedicationPrescription/hl7:code:cs code = "440545006"; (isVocab)
	// DocumentCodeMedicationPrescription/hl7:translation:cs code = "440545006"; (isVocab)
	}

	/**
	 * Creates fixed contents for CDA Element hl7Translation
	 *
	 * @param code the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CD createHl7TranslationFixedValue(String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		return retVal;
	}

	/**
	 * Gets the hl7Translation
	 * Translation to the Swiss EPR XDS.b metadata.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.CD> getHl7Translation() {
		return translation;
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
