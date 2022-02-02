/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Observation;
import org.husky.common.hl7cdar2.XActMoodDocumentObservation;
import org.husky.common.model.Code;

/**
 * LaboratoryObservation
 * <p>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.3.1.6<br>
 * Effective date: 2020-06-15 08:50:28<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class LaboratoryObservation extends POCDMT000040Observation {

    public LaboratoryObservation() {
		super.getClassCode().add("OBS");
		super.setMoodCode(XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.6"));
        super.setCode(createHl7CodeFixedValue());
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("aborted").build()));
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Adds a hl7EntryRelationship
     */
	public void addHl7EntryRelationship(org.husky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		entryRelationship.add(value);
    }

    /**
     * Adds a hl7InterpretationCode
     */
    public void addHl7InterpretationCode(org.husky.common.hl7cdar2.CE value) {
		interpretationCode.add(value);
    }

    /**
     * Adds a hl7Performer
     */
    public void addHl7Performer(org.husky.common.hl7cdar2.POCDMT000040Performer2 value) {
        getPerformer().add(value);
    }

    /**
     * Adds a hl7ReferenceRange
     */
	public void addHl7ReferenceRange(org.husky.common.hl7cdar2.POCDMT000040ReferenceRange value) {
		referenceRange.add(value);
    }

    /**
     * Adds a hl7Performer
     */
    public void clearHl7Performer() {
        getPerformer().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Organizer createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        org.husky.common.hl7cdar2.POCDMT000040Organizer retVal = new org.husky.common.hl7cdar2.POCDMT000040Organizer();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7InterpretationCode
     */
    private static org.husky.common.hl7cdar2.CE createHl7InterpretationCodeFixedValue() {
        org.husky.common.hl7cdar2.CE retVal = new org.husky.common.hl7cdar2.CE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Participant
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Participant2 createHl7ParticipantFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Participant2 retVal = factory.createPOCDMT000040Participant2();
        retVal.getTypeCode().add(typeCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7ReferenceRange
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Organizer createHl7ReferenceRangeFixedValue(String typeCode) {
        org.husky.common.hl7cdar2.POCDMT000040Organizer retVal = new org.husky.common.hl7cdar2.POCDMT000040Organizer();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CE getHl7Code() {
        return (org.husky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.husky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.husky.common.hl7cdar2.ED getHl7Text() {
		return this.text;
    }

    /**
     * Gets the hl7Value
     */
	public org.husky.common.hl7cdar2.ANY getHl7ValuePq() {
		if (this.value != null && !this.value.isEmpty()) {
			return this.value.get(0);
		}
		return null;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Organizer, filled by: "COMP", null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Organizer getPredefinedEntryRelationshipCompNull() {
        return createHl7EntryRelationshipFixedValue("COMP",
                                                    null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedInterpretationCode() {
        return createHl7InterpretationCodeFixedValue();
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Participant2, filled by: "AUTHEN"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantAuthen() {
        return createHl7ParticipantFixedValue("AUTHEN");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Organizer, filled by: "REFV"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Organizer getPredefinedReferenceRangeRefv() {
        return createHl7ReferenceRangeFixedValue("REFV");
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.husky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.husky.common.hl7cdar2.ED value) {
		this.text = value;
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.PQ value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.IVLPQ value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.INT value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
	public void setHl7Value(org.husky.common.hl7cdar2.IVLINT value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.BL value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.ST value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.CV value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.TS value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.CD value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.RTO value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
	public void setHl7Value(org.husky.common.hl7cdar2.RTOQTYQTY value) {
		setHl7AnyValue(value);
    }

    /**
     * Sets the hl7Value
     */
	public void setHl7Value(org.husky.common.hl7cdar2.RTOPQPQ value) {
		setHl7AnyValue(value);
    }

	private void setHl7AnyValue(ANY value) {
		if (this.value == null) {
			this.value = new LinkedList<>();
		}

		this.value.clear();
		this.value.add(value);
	}
}
