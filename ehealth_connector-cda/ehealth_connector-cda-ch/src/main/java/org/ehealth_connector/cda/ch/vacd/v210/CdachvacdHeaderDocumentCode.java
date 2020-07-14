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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.63 Template
 * description: A LOINC based document type of a CDA document instance including
 * a translation to the Swiss EPR XDS.b metadata.The LOINC code of the document
 * MUST read: 11369-6 (HISTORY OF IMMUNIZATIONS)
 *
 * Element description: A LOINC based document type of a CDA document instance
 * including a translation to the Swiss EPR XDS.b metadata.The LOINC code of the
 * document MUST read according to IHE PCC TF2, Rev.11: 11369-6 (HISTORY OF
 * IMMUNIZATIONS)
 */
public class CdachvacdHeaderDocumentCode extends org.ehealth_connector.common.hl7cdar2.CE {

	/**
	 * Creates fixed contents for CDA Element hl7Translation
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
	private static org.ehealth_connector.common.hl7cdar2.CD createHl7TranslationFixedValue(
			String code, String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	public CdachvacdHeaderDocumentCode() {
		super.setCode("11369-6");
		super.setCodeSystem("2.16.840.1.113883.6.1");
		super.setCodeSystemName("LOINC");
		super.setDisplayName("HISTORY OF IMMUNIZATIONS");
		super.getTranslation().add(createHl7TranslationFixedValue("41000179103",
				"2.16.840.1.113883.6.96", "SNOMED CT", "Immunization record"));
	}

	/**
	 * Gets the hl7Translation A translation to the Swiss EPR XDS.b metadata.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.CD> getHl7Translation() {
		return translation;
	}

	/**
	 * Sets the hl7Translation A translation to the Swiss EPR XDS.b metadata.
	 */
	public void setHl7Translation(org.ehealth_connector.common.hl7cdar2.CD value) {
		getTranslation().clear();
		getTranslation().add(value);
	}
}
