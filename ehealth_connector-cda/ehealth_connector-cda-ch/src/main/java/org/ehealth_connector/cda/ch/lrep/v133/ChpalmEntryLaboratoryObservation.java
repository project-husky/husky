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
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.3
 * Template description: Laboratory reports MUST contain at least one laboratory result which is declared using this element. Each laboratory result consists of code, value and interpretation of the result.CodeFor laboratory reports in Switzerland, primarly LOINC and where necessary, additional SNOMED CT codes MUST be used. At least one laboratory result for a specimen MUST thus contain a LOINC code.Certain microbiology pathogen detection can not be uniquely identified with LOINC (e.g., Campylobacter coli). Such pathogen detection must be specified in a second observation in the same Laboratory Battery Organizer with a corresponding code from another code system (e.g., SNOMED CT).For examinations according to the Swiss analysis list (AL), a translation element CAN be specified to establish the reference to the corresponding AL position.Further translation elements may be added to make reference to other codes, e.g. the locally used code in the laboratory.ValueThe concrete values measured MUST be specified in observation elements as follows (data types according to HL7 CDA):
 * - Text findings are declared as free text in the narrative portion of the corresponding section, and the text element MUST contain the corresponding reference to the narrative text. In this case, the observation MAY NOT contain the value element.
 * - True / False values are declared using the data type BL.
 * - Encoded values are declared using the data type CD.
 * - Numeric results are declared using data type PQ in combination with internationally standardized units (UCUM), according to the value set.
 * - Ratios are declared with data type RTO.InterpretationThe interpretation code specifies AT LEAST whether it is a normal result or a result outside the normal range. Further interpretation codes CAN be used.
 *
 * Element description: Laboratory result with interpretation, related previous results, reference range, participants (persons and devices) as well as comments.
 */
public class ChpalmEntryLaboratoryObservation extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public ChpalmEntryLaboratoryObservation() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.6"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.3"));
		codeFixedValue = createHl7CodeFixedValue("NAV");
	// chpalm_entry_LaboratoryObservation/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.1.6";
	// chpalm_entry_LaboratoryObservation/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.3";
	// chpalm_entry_LaboratoryObservation/hl7:code:st nullFlavor = "NAV";
	// chpalm_entry_LaboratoryObservation/hl7:statusCode:cs valueSet = valueSet("1.3.6.1.4.1.19376.1.3.11.2");
	// chpalm_entry_LaboratoryObservation/hl7:value:cs nullFlavor = "NA";
	// chpalm_entry_LaboratoryObservation/hl7:value:cs nullFlavor = "NA";
	// chpalm_entry_LaboratoryObservation/hl7:value:cs nullFlavor = "NA";
	// chpalm_entry_LaboratoryObservation/hl7:value:cs nullFlavor = "NA";
	// chpalm_entry_LaboratoryObservation/hl7:interpretationCode:cs valueSet = valueSet("2.16.840.1.113883.1.11.78");
	// chpalm_entry_LaboratoryObservation/hl7:entryRelationship:cs typeCode = "COMP";
	// chpalm_entry_LaboratoryObservation/hl7:entryRelationship:cs typeCode = "SUBJ";
	// chpalm_entry_LaboratoryObservation/hl7:entryRelationship:bl inversionInd = "true";
	// chpalm_entry_LaboratoryObservation/hl7:entryRelationship:cs typeCode = "REFR";
	// chpalm_entry_LaboratoryObservation/hl7:reference:cs typeCode = "REFR";
	// chpalm_entry_LaboratoryObservation/hl7:referenceRange:cs typeCode = "REFV";
	}

	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CD codeFixedValue;

	/**
	 * Adds a hl7Author
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7EntryRelationship
	 * Information on specimen collection for this Observation. This information supersedes any information recorded at higher level.
	 */
	public void addHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().add(value);
	}

	/**
	 * Adds a hl7Participant
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		getParticipant().add(value);
	}

	/**
	 * Adds a hl7Performer
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	public void addHl7Performer(org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		getPerformer().add(value);
	}

	/**
	 * Adds a hl7Reference
	 * This CAN be used to make reference to an external document.
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().add(value);
	}

	/**
	 * Adds a hl7Author
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7EntryRelationship
	 * Information on specimen collection for this Observation. This information supersedes any information recorded at higher level.
	 */
	public void clearHl7EntryRelationship() {
		getEntryRelationship().clear();
	}

	/**
	 * Adds a hl7Participant
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant() {
		getParticipant().clear();
	}

	/**
	 * Adds a hl7Performer
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Performer() {
		getPerformer().clear();
	}

	/**
	 * Adds a hl7Reference
	 * This CAN be used to make reference to an external document.
	 */
	public void clearHl7Reference() {
		getReference().clear();
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7EntryRelationship
	 *
	 * @param typeCode the desired fixed value for this argument.
	 * @param inversionInd the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
		retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7Reference
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference createHl7ReferenceFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference retVal = factory.createPOCDMT000040Reference();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipExternalReference.fromValue(typeCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7ReferenceRange
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange createHl7ReferenceRangeFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange retVal = factory.createPOCDMT000040ReferenceRange();
		retVal.getTypeCode().add(typeCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7Value
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.BL createHl7ValueFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.BL retVal = factory.createBL();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Gets the member codeFixedValue
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getCodeFixedValue() {
		return codeFixedValue;
	}

	/**
	 * Gets the hl7Code
	 * A unique code for this result MUST be specified.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * The result of the examination MUST be specified for all elements with status 'completed'. One of the following data types MUST be used. For elements with status 'aborted', the result of the test is NOT ALLOWED.In the case of microbiological or infection-serological detection of pathogens, NO value element is PERMITTED. Instead, declare using the interpretationCode whether the pathogen was detected in the sample (POS) or not (NEG).
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getId() != null)
			if (getId().size() > 0)
				retVal = getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7InterpretationCode
	 * IF this result is based on a specimen of a non-human material, this MUST be declared with the subject element.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7InterpretationCode() {
		org.ehealth_connector.common.hl7cdar2.CE retVal = null;
		if (getInterpretationCode() != null)
			if (getInterpretationCode().size() > 0)
				retVal = getInterpretationCode().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7ReferenceRange
	 * The reference range SHALL be specified for the range of normal values for the data types PQ and INT. The following applies:
	 * - Upper limit: [R]
	 * - Lower limit: [R]
	 * - interpretationCode containing code=N: [M]The reference range CAN be omitted for other data types. If only an upper or lower limit is meaningful, the unused limit MUST be declared using nullFlavor.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange getHl7ReferenceRange() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange retVal = null;
		if (getReferenceRange() != null)
			if (getReferenceRange().size() > 0)
				retVal = getReferenceRange().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means that the result is final.The status 'aborted' means that the examination could not be performed.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7Subject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject() {
		return subject;
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
	 * Gets the hl7Text
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Gets the hl7Value
	 * True / False or Yes / No Result. If the observation value can not be determined, @value is NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public org.ehealth_connector.common.hl7cdar2.BL getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.BL retVal = null;
		if (getValue() != null)
			if (getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.BL) getValue().get(0);
		return retVal;
	}

	/**
	 * Sets the hl7Code
	 * A unique code for this result MUST be specified.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * The result of the examination MUST be specified for all elements with status 'completed'. One of the following data types MUST be used. For elements with status 'aborted', the result of the test is NOT ALLOWED.In the case of microbiological or infection-serological detection of pathogens, NO value element is PERMITTED. Instead, declare using the interpretationCode whether the pathogen was detected in the sample (POS) or not (NEG).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7InterpretationCode
	 * IF this result is based on a specimen of a non-human material, this MUST be declared with the subject element.
	 */
	public void setHl7InterpretationCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		getInterpretationCode().clear();
		getInterpretationCode().add(value);
	}

	/**
	 * Sets the hl7ReferenceRange
	 * The reference range SHALL be specified for the range of normal values for the data types PQ and INT. The following applies:
	 * - Upper limit: [R]
	 * - Lower limit: [R]
	 * - interpretationCode containing code=N: [M]The reference range CAN be omitted for other data types. If only an upper or lower limit is meaningful, the unused limit MUST be declared using nullFlavor.
	 */
	public void setHl7ReferenceRange(org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange value) {
		getReferenceRange().clear();
		getReferenceRange().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means that the result is final.The status 'aborted' means that the examination could not be performed.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.statusCode = value;
	}

	/**
	 * Sets the hl7Subject
	 */
	public void setHl7Subject(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		this.subject = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}

	/**
	 * Sets the hl7Value
	 * True / False or Yes / No Result. If the observation value can not be determined, @value is NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.BL value) {
		getValue().clear();
		getValue().add(value);
	}
}
