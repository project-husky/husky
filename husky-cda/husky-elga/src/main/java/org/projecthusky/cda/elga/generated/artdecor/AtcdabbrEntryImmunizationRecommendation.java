/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.model.Code;

/**
 * atcdabbr_entry_ImmunizationRecommendation
 * <p>
 * Element description: An immunization recommendation entry is used to record the patient's immunization plan. An immunization recommendation is a substance administration proposal or a documentation of an intended, but not yet administered immunization. An immunization recommendation entry may also be a record of a specific immunization that shouldn't performed. In this case, negationInd shall be set to "true", otherwise, it shall be "false".<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.3<br>
 * Effective date: 2022-01-25 14:14:04<br>
 * Version: 1.3.0+20220127<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrEntryImmunizationRecommendation extends POCDMT000040SubstanceAdministration {

    public AtcdabbrEntryImmunizationRecommendation() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood.PRP);
		super.setNegationInd(Boolean.FALSE);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.3"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.25"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.12.2"));
        vocabCodeValueSet.add(new Code(CodeBaseType.builder().withCode("IMMUNIZ").withCodeSystem("2.16.840.1.113883.5.4").build()));
        code = (new Code(CodeBaseType.builder().withCode("IMMUNIZ").withCodeSystem("2.16.840.1.113883.5.4").build())).getHl7CdaR2Cd();
		super.setCode(code);
        super.setStatusCode(createHl7StatusCodeFixedValue("active"));
        super.setRouteCode(createHl7RouteCodeFixedValue("NA"));
        super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("RSON",
                                                                              "true"));
    }

    private final List<Code> vocabCodeValueSet = new ArrayList<>();

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void addHl7ApproachSiteCode(org.projecthusky.common.hl7cdar2.CD value) {
        getApproachSiteCode().add(value);
    }

    /**
     * Adds a hl7EntryRelationship
     */
    public void addHl7EntryRelationship(org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().add(value);
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void clearHl7ApproachSiteCode() {
        getApproachSiteCode().clear();
    }

    /**
     * Adds a hl7EntryRelationship
     */
    public void clearHl7EntryRelationship() {
        getEntryRelationship().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7ApproachSiteCode
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CD createHl7ApproachSiteCodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CD retVal = factory.createCD();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.projecthusky.common.hl7cdar2.CD createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CD retVal = factory.createCD();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Consumable
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Consumable createHl7ConsumableFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Consumable retVal = factory.createPOCDMT000040Consumable();
        retVal.getTypeCode().add(typeCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.IVLPQ retVal = factory.createIVLPQ();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
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
     * Creates fixed contents for CDA Element hl7Precondition
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Precondition createHl7PreconditionFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Precondition retVal = factory.createPOCDMT000040Precondition();
        retVal.getTypeCode().add(typeCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Reference
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Reference createHl7ReferenceFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Reference retVal = factory.createPOCDMT000040Reference();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipExternalReference.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RouteCode
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7RouteCodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
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
     * Gets the hl7Author
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Consumable
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
        return consumable;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.projecthusky.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
        return doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public List<SXCMTS> getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id<br/>
     * Immunization ID, assigned by the software application.
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7Precondition
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Precondition> getHl7Precondition() {
        return precondition;
    }

    /**
     * Gets the hl7Reference
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
        return reference;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7RouteCode() {
        return routeCode;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.projecthusky.common.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CD, filled by: "NA"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CD getPredefinedApproachSiteCodeNa() {
        return createHl7ApproachSiteCodeFixedValue("NA");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Consumable, filled by: "CSM"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getPredefinedConsumableCsm() {
        return createHl7ConsumableFixedValue("CSM");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLPQ, filled by: "NA"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantityNa() {
        return createHl7DoseQuantityFixedValue("NA");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "RSON", "true"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRsonTrue() {
        return createHl7EntryRelationshipFixedValue("RSON",
                                                    "true");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Participant2, filled by: "AUT", "OP"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantAutOp() {
        return createHl7ParticipantFixedValue("AUT",
                                              "OP");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Participant2, filled by: "ENT", "OP"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantEntOp() {
        return createHl7ParticipantFixedValue("ENT",
                                              "OP");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Participant2, filled by: "VRF", "OP"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantVrfOp() {
        return createHl7ParticipantFixedValue("VRF",
                                              "OP");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Reference, filled by: "REFR"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Reference getPredefinedReferenceRefr() {
        return createHl7ReferenceFixedValue("REFR");
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabCodeValueSet() {
        return vocabCodeValueSet;
    }

    /**
     * Sets the hl7Author
     */
    public void setHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7Consumable
     */
    public void setHl7Consumable(org.projecthusky.common.hl7cdar2.POCDMT000040Consumable value) {
        this.consumable = value;
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.projecthusky.common.hl7cdar2.IVLPQ value) {
        this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7Id<br/>
     * Immunization ID, assigned by the software application.
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7Precondition
     */
    public void setHl7Precondition(org.projecthusky.common.hl7cdar2.POCDMT000040Precondition value) {
        getPrecondition().clear();
        getPrecondition().add(value);
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.projecthusky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().clear();
        getReference().add(value);
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.routeCode = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.projecthusky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.projecthusky.common.hl7cdar2.ED value) {
        this.text = value;
    }
}
