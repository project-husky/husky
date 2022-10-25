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
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.model.Code;

/**
 * atcdabbr_entry_ExpositionsrisikoProblemConcern
 * Identifier: 1.2.40.0.34.6.0.11.3.20<br>
 * Effective date: 2021-10-29 13:52:30<br>
 * Version: 1.0.2+20220103<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrEntryExpositionsrisikoProblemConcern extends POCDMT000040Act {

    public AtcdabbrEntryExpositionsrisikoProblemConcern() {
        super.setClassCode(org.projecthusky.common.hl7cdar2.XActClassDocumentEntryAct.ACT);
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XDocumentActMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.20"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.27"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5.2"));
        super.setCode(createHl7CodeFixedValue("NA"));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("active").build()));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
        super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("SUBJ",
                                                                              "false",
                                                                              "true"));
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     * @param contextConductionInd the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd, String contextConductionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
        if (inversionInd != null) {
            retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
        }
        if (contextConductionInd != null) {
            retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
        }
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
     * Gets the hl7Id
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Reference
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
        return reference;
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
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Reference, filled by: "REFR"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Reference getPredefinedReferenceRefr() {
        return createHl7ReferenceFixedValue("REFR");
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
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
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.projecthusky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().clear();
        getReference().add(value);
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
}
