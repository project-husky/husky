package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
import org.husky.common.hl7cdar2.POCDMT000040Supply;

/**
 * DispenseItemEntryContentModule
 * <p>
 * Template description: A Dispense Item belongs to one Dispensation and represents one dispensed medication. It contains the dispensed medicinal product including information such as product code, brand name and packaging information.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.42<br>
 * Effective date: 2016-06-17 00:00:00<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class DispenseItemEntryContentModule extends POCDMT000040Supply {

    public DispenseItemEntryContentModule() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.42"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.4"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.3"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.34"));
    }

    /**
     * Adds a hl7Reference
     * ID of parent container (Community Dispense document)
     */
    public void addHl7Reference(POCDMT000040Reference value) {
        getReference().add(value);
    }

    /**
     * Adds a hl7Reference
     * ID of parent container (Community Dispense document)
     */
    public void clearHl7Reference() {
        getReference().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static CD createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        CD retVal = factory.createCD();
        return retVal;
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
     * Dispenser
     */
    public List<POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Code
     * Code
     */
    public CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EntryRelationship
     * If the dispense is related to a Medication Treatment Plan Item, the reference to it SHALL be present.
     */
    public List<POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7Id
     * Dispense Item ID
     */
    public List<II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Product
     * Product
     */
    public POCDMT000040Product getHl7Product() {
        return product;
    }

    /**
     * Gets the hl7Quantity
     * Quantity Value
     */
    public PQ getHl7Quantity() {
        return quantity;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     * Narrative Text
     */
    public ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.CD, filled by:
     * @return the predefined element.
     */
    public static CD getPredefinedCode() {
        return createHl7CodeFixedValue();
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
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", null
     * @return the predefined element.
     */
    public static POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "SUBJ", "true"
     * @return the predefined element.
     */
    public static POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjTrue() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    "true");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Reference, filled by: "XCRPT"
     * @return the predefined element.
     */
    public static POCDMT000040Reference getPredefinedReferenceXcrpt() {
        return createHl7ReferenceFixedValue("XCRPT");
    }

    /**
     * Sets the hl7Author
     * Dispenser
     */
    public void setHl7Author(POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Code
     * Code
     */
    public void setHl7Code(CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EntryRelationship
     * If the dispense is related to a Medication Treatment Plan Item, the reference to it SHALL be present.
     */
    public void setHl7EntryRelationship(POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7Id
     * Dispense Item ID
     */
    public void setHl7Id(II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Product
     * Product
     */
    public void setHl7Product(POCDMT000040Product value) {
        this.product = value;
    }

    /**
     * Sets the hl7Quantity
     * Quantity Value
     */
    public void setHl7Quantity(PQ value) {
        this.quantity = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     * Narrative Text
     */
    public void setHl7Text(ED value) {
        this.text = value;
    }
}
