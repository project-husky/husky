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

import javax.xml.bind.JAXBElement;
import org.ehealth_connector.common.hl7cdar2.ActRelationshipHasComponent;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipExternalReference;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.85
 * Template description: Coding of a pathogen detection.
 *
 * Element description: Coding of a pathogen detection.
 */
public class CdachlrepEntryLaboratoryIsolateOrganizerPathogenDetection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Organizer {

	public CdachlrepEntryLaboratoryIsolateOrganizerPathogenDetection() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.85"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.17"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.5"));
	}

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
	 * Adds a hl7Component
	 * Coding of the method. The observation MUST be coded by a LOINC code having culture as method. Use the filter 'method:culture' on search.loinc.org (see https://search.loinc.org/searchLOINC/search.zul?query=method%3Aculture)
	 */
	public void addHl7Component(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		getComponent().add(value);
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
	 * Adds a hl7Component
	 * Coding of the method. The observation MUST be coded by a LOINC code having culture as method. Use the filter 'method:culture' on search.loinc.org (see https://search.loinc.org/searchLOINC/search.zul?query=method%3Aculture)
	 */
	public void clearHl7Component() {
		getComponent().clear();
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
	 * Creates fixed contents for hl7Component
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 createHl7ComponentFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 retVal = factory.createPOCDMT000040Component4();
		retVal.setTypeCode(ActRelationshipHasComponent.fromValue(typeCode));
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
		retVal.setTypeCode(XActRelationshipExternalReference.fromValue(typeCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7Specimen
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Specimen createHl7SpecimenFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Specimen retVal = factory.createPOCDMT000040Specimen();
		retVal.getTypeCode().add(typeCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7StatusCode
	 *
	 * @param code the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
		retVal.setCode(code);
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
	 * Gets the hl7Code
	 * If the results in this isolate group are associated to a codable group, then the code SHOULD be specified. The code system is not further specified. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.IF this isolate group contains any other results, then the code SHOULD be omitted.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return (org.ehealth_connector.common.hl7cdar2.CE) super.code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp or period of findings (physiologically relevant period) for all results in this result group.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getId() != null)
			if (super.getId().size() > 0)
				retVal = super.getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Specimen
	 * The specific sub-specimen on which a microorganism was isolated and cultivated.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Specimen getHl7Specimen() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Specimen retVal = null;
		if (super.getSpecimen() != null)
			if (super.getSpecimen().size() > 0)
				retVal = super.getSpecimen().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means that all expected results for this isolate are present and in a final state.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return super.statusCode;
	}

	/**
	 * Gets the hl7Subject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject() {
		return super.subject;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getTemplateId() != null)
			if (super.getTemplateId().size() > 0)
				retVal = super.getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Sets the hl7Code
	 * If the results in this isolate group are associated to a codable group, then the code SHOULD be specified. The code system is not further specified. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.IF this isolate group contains any other results, then the code SHOULD be omitted.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp or period of findings (physiologically relevant period) for all results in this result group.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		super.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getId().clear();
		super.getId().add(value);
	}

	/**
	 * Sets the hl7Specimen
	 * The specific sub-specimen on which a microorganism was isolated and cultivated.
	 */
	public void setHl7Specimen(org.ehealth_connector.common.hl7cdar2.POCDMT000040Specimen value) {
		super.getSpecimen().clear();
		super.getSpecimen().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means that all expected results for this isolate are present and in a final state.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.statusCode = value;
	}

	/**
	 * Sets the hl7Subject
	 */
	public void setHl7Subject(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		super.subject = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}
}
