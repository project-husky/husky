/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Observation;
import org.husky.emed.cda.models.common.Code;
import org.husky.emed.cda.models.common.basetypes.CodeBaseType;

/**
 * PharmaceuticalAdviceItemEntryContentModule
 * <p>
 * Template description: A Pharmaceutical Advice Item belongs to one Pharmaceutical Advice and represents the validation outcome or management command regarding the referenced Medication Treatment Plan-, Prescription- or Dispense Item (e.g., change, cancel, etc.).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.44<br>
 * Effective date: 2016-06-25 00:00:00<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-11-24")
public class PharmaceuticalAdviceItemEntryContentModule extends POCDMT000040Observation {

    public PharmaceuticalAdviceItemEntryContentModule() {
        super.setMoodCode(org.husky.common.hl7cdar2.XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.44"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.3"));
        vocabCodeCode.add(new Code(CodeBaseType.builder().withCode("OK").withCodeSystem("1.3.6.1.4.1.19376.1.9.2.1").build()));
        vocabCodeCode.add(new Code(CodeBaseType.builder().withCode("CHANGE").withCodeSystem("1.3.6.1.4.1.19376.1.9.2.1").build()));
        vocabCodeCode.add(new Code(CodeBaseType.builder().withCode("CANCEL").withCodeSystem("1.3.6.1.4.1.19376.1.9.2.1").build()));
        vocabCodeCode.add(new Code(CodeBaseType.builder().withCode("SUSPEND").withCodeSystem("1.3.6.1.4.1.19376.1.9.2.1").build()));
        vocabCodeCode.add(new Code(CodeBaseType.builder().withCode("REFUSE").withCodeSystem("1.3.6.1.4.1.19376.1.9.2.1").build()));
        vocabCodeCode.add(new Code(CodeBaseType.builder().withCode("COMMENT").withCodeSystem("1.3.6.1.4.1.19376.1.9.2.1").build()));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("active").build()));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
    }

    private final List<Code> vocabCodeCode = new ArrayList<>();

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Adds a hl7Id/Pharmaceutical Advice Item ID
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Reference/ID of parent container (Community Pharmaceutical Advice document)
     */
    public void addHl7Reference(org.husky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().add(value);
    }

    /**
     * Adds a hl7Id/Pharmaceutical Advice Item ID
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Adds a hl7Reference/ID of parent container (Community Pharmaceutical Advice document)
     */
    public void clearHl7Reference() {
        getReference().clear();
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
     * Creates fixed contents for CDA Element hl7Reference
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Reference createHl7ReferenceFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Reference retVal = factory.createPOCDMT000040Reference();
        retVal.setTypeCode(org.husky.common.hl7cdar2.XActRelationshipExternalReference.fromValue(typeCode));
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
     * Gets the hl7Author/Pharmaceutical Adviser
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Code/Observation Code
     */
    public org.husky.common.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime/Effective Time (Date of becoming effective)
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
     * Gets the hl7StatusCode
     */
    public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId/CH-PHARM-PharmaceuticalAdviceItemEntryContentModule
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.husky.common.hl7cdar2.ED getHl7Text() {
        return text;
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
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", "false"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrFalse() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    "false");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Reference, filled by: "XCRPT"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Reference getPredefinedReferenceXcrpt() {
        return createHl7ReferenceFixedValue("XCRPT");
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabCodeCode() {
        return vocabCodeCode;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
    }

    /**
     * Sets the hl7Author<br/>
     * Pharmaceutical Adviser
     */
    public void setHl7Author(org.husky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Code<br/>
     * Observation Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * Effective Time (Date of becoming effective)
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
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId<br/>
     * CH-PHARM-PharmaceuticalAdviceItemEntryContentModule
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
}
