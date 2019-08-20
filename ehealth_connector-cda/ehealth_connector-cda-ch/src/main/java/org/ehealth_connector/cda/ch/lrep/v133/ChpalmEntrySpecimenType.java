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

import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.27
 * Template description: Specimen Type.
 *
 * Element description: IF the coding of the specimen with LOINC's 'System' axis is insufficient, a precise code CAN be used. The use of SNOMED-CT is recommended.
 */
public class ChpalmEntrySpecimenType {

	public ChpalmEntrySpecimenType() {
		this.code = createHl7CodeFixedValue("LOINC", "2.16.756.5.30.2.1.1.10", "CDA-CH Material");
	// chpalm_entry_SpecimenType/hl7:code:cs code = "LOINC";
	// chpalm_entry_SpecimenType/hl7:code:oid codeSystem = "2.16.756.5.30.2.1.1.10";
	// chpalm_entry_SpecimenType/hl7:code:st codeSystemName = "CDA-CH Material";
	}

	/**
	 * IHE XD-LAB requires coding of the specimen. However, since the laboratory results have to be coded with LOINC, the specimen is already defined via the 'System' axis of LOINC. Therefore the following, fixed code CAN be used for laboratory reports in Switzerland.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CE code;

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code the desired fixed value for this argument.
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 * IHE XD-LAB requires coding of the specimen. However, since the laboratory results have to be coded with LOINC, the specimen is already defined via the 'System' axis of LOINC. Therefore the following, fixed code CAN be used for laboratory reports in Switzerland.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Sets the hl7Code
	 * IHE XD-LAB requires coding of the specimen. However, since the laboratory results have to be coded with LOINC, the specimen is already defined via the 'System' axis of LOINC. Therefore the following, fixed code CAN be used for laboratory reports in Switzerland.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}
}
