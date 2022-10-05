/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Procedure;

/**
 * epims_entry_specimenCollection
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.55<br>
 * Effective date: 2020-02-20 14:17:08<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntrySpecimenCollection extends POCDMT000040Procedure {

    public EpimsEntrySpecimenCollection() {
        super.getClassCode().add("PROC");
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XDocumentProcedureMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.55"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.2"));
        super.setCode(createHl7CodeFixedValue("33882-2",
                                              "2.16.840.1.113883.6.1",
                                              null,
                                              null));
        super.getParticipant().add(createHl7ParticipantFixedValue("PRD",
                                                                  "OP"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
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
     * @param contextConductionInd the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String contextConductionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
        if (contextConductionInd != null) {
            retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7MethodCode
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7MethodCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Participant
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextControlCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 createHl7ParticipantFixedValue(String typeCode, String contextControlCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 retVal = factory.createPOCDMT000040Participant2();
        retVal.getTypeCode().add(typeCode);
        retVal.setContextControlCode(contextControlCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Performer
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 createHl7PerformerFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 retVal = factory.createPOCDMT000040Performer2();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.ParticipationPhysicalPerformer.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TargetSiteCode
     */
    private static org.projecthusky.common.hl7cdar2.CD createHl7TargetSiteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CD retVal = factory.createCD();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
        return (org.projecthusky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.projecthusky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EntryRelationship
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7MethodCode
     */
    public List<org.projecthusky.common.hl7cdar2.CE> getHl7MethodCode() {
        return methodCode;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7Performer
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Performer2> getHl7Performer() {
        return performer;
    }

    /**
     * Gets the hl7TargetSiteCode
     */
    public List<org.projecthusky.common.hl7cdar2.CD> getHl7TargetSiteCode() {
        return targetSiteCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "COMP", "true"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipCompTrue() {
        return createHl7EntryRelationshipFixedValue("COMP",
                                                    "true");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedMethodCode() {
        return createHl7MethodCodeFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Performer2, filled by: "PRF"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 getPredefinedPerformerPrf() {
        return createHl7PerformerFixedValue("PRF");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CD, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CD getPredefinedTargetSiteCode() {
        return createHl7TargetSiteCodeFixedValue();
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7EntryRelationship
     */
    public void setHl7EntryRelationship(org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7MethodCode
     */
    public void setHl7MethodCode(org.projecthusky.common.hl7cdar2.CE value) {
        getMethodCode().clear();
        getMethodCode().add(value);
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7Performer
     */
    public void setHl7Performer(org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 value) {
        getPerformer().clear();
        getPerformer().add(value);
    }

    /**
     * Sets the hl7TargetSiteCode
     */
    public void setHl7TargetSiteCode(org.projecthusky.common.hl7cdar2.CD value) {
        getTargetSiteCode().clear();
        getTargetSiteCode().add(value);
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
