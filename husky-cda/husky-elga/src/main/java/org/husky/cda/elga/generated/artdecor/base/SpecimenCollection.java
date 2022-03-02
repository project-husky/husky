/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Procedure;

/**
 * SpecimenCollection
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30021<br>
 * Effective date: 2014-03-04 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class SpecimenCollection extends POCDMT000040Procedure {

    public SpecimenCollection() {
        super.getClassCode().add("PROC");
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentProcedureMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.2"));
        super.setCode(createHl7CodeFixedValue("33882-2",
                                              "2.16.840.1.113883.6.1",
                                              null,
                                              null));
        super.getParticipant().add(createHl7ParticipantFixedValue("PRD"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.husky.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
        if (inversionInd != null) {
            retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
        }
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
     * Creates fixed contents for CDA Element hl7Performer
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Performer2 createHl7PerformerFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Performer2 retVal = factory.createPOCDMT000040Performer2();
        retVal.setTypeCode(org.husky.common.hl7cdar2.ParticipationPhysicalPerformer.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TargetSiteCode
     */
    private static org.husky.common.hl7cdar2.CD createHl7TargetSiteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CD retVal = factory.createCD();
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
     * Gets the hl7EntryRelationship
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7Performer
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Performer2> getHl7Performer() {
        return performer;
    }

    /**
     * Gets the hl7TargetSiteCode
     */
    public List<org.husky.common.hl7cdar2.CD> getHl7TargetSiteCode() {
        return targetSiteCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "COMP", null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipCompNull() {
        return createHl7EntryRelationshipFixedValue("COMP",
                                                    null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Performer2, filled by: "PRF"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Performer2 getPredefinedPerformerPrf() {
        return createHl7PerformerFixedValue("PRF");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CD, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CD getPredefinedTargetSiteCode() {
        return createHl7TargetSiteCodeFixedValue();
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
     * Sets the hl7EntryRelationship
     */
    public void setHl7EntryRelationship(org.husky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.husky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7Performer
     */
    public void setHl7Performer(org.husky.common.hl7cdar2.POCDMT000040Performer2 value) {
        getPerformer().clear();
        getPerformer().add(value);
    }

    /**
     * Sets the hl7TargetSiteCode
     */
    public void setHl7TargetSiteCode(org.husky.common.hl7cdar2.CD value) {
        getTargetSiteCode().clear();
        getTargetSiteCode().add(value);
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
