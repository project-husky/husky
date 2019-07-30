/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lrep;

import java.util.ArrayList;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.19
 * Template description: According to IHE XD-LAB, the Laboratory Battery Organizer allows the grouping of results.Laboratory reports MUST contain at least one result group with at least one result.The grouping of multiple results (Observations) into multiple result groups (Laboratory Battery Organizers) is permitted.
 */
public class ChpalmEntryLaboratoryBatteryOrganizer extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Organizer {

	/**
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author> hl7Author;

	/**
	 * IF the results in this result group are associated to a codable group (e.g., LOINC Code 55429-5 for 'short blood count panel'), then the code SHOULD be specified. The code system is not further specified. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.IF this result group contains any other results, then the code SHOULD be omitted.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7Code;

	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component;

	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component1;

	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component2;

	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4> hl7Component3;

	/**
	 * Timestamp or period of findings (physiologically relevant period) for all results in this result group.
	 */
	private org.ehealth_connector.common.hl7cdar2.IVLTS hl7EffectiveTime;

	/**
	 * An ID for this item MAY be filled for traceability.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	/**
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2> hl7Participant;

	/**
	 * Which external laboratory has delivered the result (RESP). This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2> hl7Participant1;

	/**
	 * Which device (analyzer) was used to determine the result (DEV). This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2> hl7Participant2;

	/**
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2> hl7Performer;

	/**
	 * This CAN be used to make reference to an external document.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference> hl7Reference;

	/**
	 * The status 'completed' means that all expected results for this results group are present and in a final state.The status 'aborted' means that the examinations had to be aborted. Some results MAY be available.
	 */
	private org.ehealth_connector.common.hl7cdar2.CS hl7StatusCode;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject hl7Subject;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject hl7Subject1;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * Adds a hl7Author
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		hl7Author.add(value);
	}

	/**
	 * Adds a hl7Component
	 */
	public void addHl7Component(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		hl7Component.add(value);
	}

	/**
	 * Adds a hl7Component1
	 */
	public void addHl7Component1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		hl7Component1.add(value);
	}

	/**
	 * Adds a hl7Component2
	 */
	public void addHl7Component2(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		hl7Component2.add(value);
	}

	/**
	 * Adds a hl7Component3
	 */
	public void addHl7Component3(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component4 value) {
		hl7Component3.add(value);
	}

	/**
	 * Adds a hl7Participant
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		hl7Participant.add(value);
	}

	/**
	 * Adds a hl7Participant1
	 * Which external laboratory has delivered the result (RESP). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		hl7Participant1.add(value);
	}

	/**
	 * Adds a hl7Participant2
	 * Which device (analyzer) was used to determine the result (DEV). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant2(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		hl7Participant2.add(value);
	}

	/**
	 * Adds a hl7Performer
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	public void addHl7Performer(org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		hl7Performer.add(value);
	}

	/**
	 * Adds a hl7Reference
	 * This CAN be used to make reference to an external document.
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		hl7Reference.add(value);
	}

	/**
	 * Adds a hl7Author
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	public void clearHl7Author() {
		hl7Author.clear();
	}

	/**
	 * Adds a hl7Component
	 */
	public void clearHl7Component() {
		hl7Component.clear();
	}

	/**
	 * Adds a hl7Component1
	 */
	public void clearHl7Component1() {
		hl7Component1.clear();
	}

	/**
	 * Adds a hl7Component2
	 */
	public void clearHl7Component2() {
		hl7Component2.clear();
	}

	/**
	 * Adds a hl7Component3
	 */
	public void clearHl7Component3() {
		hl7Component3.clear();
	}

	/**
	 * Adds a hl7Participant
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant() {
		hl7Participant.clear();
	}

	/**
	 * Adds a hl7Participant1
	 * Which external laboratory has delivered the result (RESP). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant1() {
		hl7Participant1.clear();
	}

	/**
	 * Adds a hl7Participant2
	 * Which device (analyzer) was used to determine the result (DEV). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant2() {
		hl7Participant2.clear();
	}

	/**
	 * Adds a hl7Performer
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Performer() {
		hl7Performer.clear();
	}

	/**
	 * Adds a hl7Reference
	 * This CAN be used to make reference to an external document.
	 */
	public void clearHl7Reference() {
		hl7Reference.clear();
	}

	/**
	 * Gets the hl7Code
	 * IF the results in this result group are associated to a codable group (e.g., LOINC Code 55429-5 for 'short blood count panel'), then the code SHOULD be specified. The code system is not further specified. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.IF this result group contains any other results, then the code SHOULD be omitted.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp or period of findings (physiologically relevant period) for all results in this result group.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means that all expected results for this results group are present and in a final state.The status 'aborted' means that the examinations had to be aborted. Some results MAY be available.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return hl7StatusCode;
	}

	/**
	 * Gets the hl7Subject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject() {
		return hl7Subject;
	}

	/**
	 * Gets the hl7Subject1
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject1() {
		return hl7Subject1;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7TemplateId1
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId1() {
		return hl7TemplateId1;
	}

	/**
	 * Sets the hl7Code
	 * IF the results in this result group are associated to a codable group (e.g., LOINC Code 55429-5 for 'short blood count panel'), then the code SHOULD be specified. The code system is not further specified. LOINC (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or values from the HL7 vocabulary ObservationType (2.16.840.1.113883.1.11.16226) SHOULD be used.IF this result group contains any other results, then the code SHOULD be omitted.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp or period of findings (physiologically relevant period) for all results in this result group.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means that all expected results for this results group are present and in a final state.The status 'aborted' means that the examinations had to be aborted. Some results MAY be available.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		hl7StatusCode = value;
	}

	/**
	 * Sets the hl7Subject
	 */
	public void setHl7Subject(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		hl7Subject = value;
	}

	/**
	 * Sets the hl7Subject1
	 */
	public void setHl7Subject1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		hl7Subject1 = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7TemplateId1
	 */
	public void setHl7TemplateId1(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId1 = value;
	}
}
