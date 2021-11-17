package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
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
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class PharmaceuticalAdviceItemEntryContentModule extends POCDMT000040Observation {

    public PharmaceuticalAdviceItemEntryContentModule() {
        super.setMoodCode(XActMoodDocumentObservation.EVN);
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
     * Adds a hl7Id
     * Pharmaceutical Advice Item ID
     */
    public void addHl7Id(II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Reference
     * ID of parent container (Community Pharmaceutical Advice document)
     */
    public void addHl7Reference(POCDMT000040Reference value) {
        getReference().add(value);
    }

    /**
     * Adds a hl7Id
     * Pharmaceutical Advice Item ID
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Adds a hl7Reference
     * ID of parent container (Community Pharmaceutical Advice document)
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
    private static POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        ObjectFactory factory = new ObjectFactory();
        POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(XActRelationshipEntryRelationship.fromValue(typeCode));
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
    private static POCDMT000040Reference createHl7ReferenceFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        POCDMT000040Reference retVal = factory.createPOCDMT000040Reference();
        retVal.setTypeCode(XActRelationshipExternalReference.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Author
     * Pharmaceutical Adviser
     */
    public List<POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Code
     * Observation Code
     */
    public CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     * Effective Time (Date of becoming effective)
     */
    public IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EntryRelationship
     */
    public List<POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7StatusCode
     */
    public CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     * CH-PHARM-PharmaceuticalAdviceItemEntryContentModule
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "COMP", null
     * @return the predefined element.
     */
    public static POCDMT000040EntryRelationship getPredefinedEntryRelationshipCompNull() {
        return createHl7EntryRelationshipFixedValue("COMP",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", "false"
     * @return the predefined element.
     */
    public static POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrFalse() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    "false");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", null
     * @return the predefined element.
     */
    public static POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Reference, filled by: "XCRPT"
     * @return the predefined element.
     */
    public static POCDMT000040Reference getPredefinedReferenceXcrpt() {
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
     * Sets the hl7Author
     * Pharmaceutical Adviser
     */
    public void setHl7Author(POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Code
     * Observation Code
     */
    public void setHl7Code(CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     * Effective Time (Date of becoming effective)
     */
    public void setHl7EffectiveTime(IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7EntryRelationship
     */
    public void setHl7EntryRelationship(POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     * CH-PHARM-PharmaceuticalAdviceItemEntryContentModule
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(ED value) {
        this.text = value;
    }
}
