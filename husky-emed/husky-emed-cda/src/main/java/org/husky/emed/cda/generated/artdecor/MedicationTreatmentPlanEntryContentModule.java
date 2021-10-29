package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.emed.cda.generated.hl7cdar2.SXCMTS;

/**
 * MedicationTreatmentPlanEntryContentModule
 * <p>
 * Template description: A medication treatment plan item is an entity describing a medication included in the medication treatment plan of the patient. See also<a href="http://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_MTP.pdf">IHE Pharmacy MTP Suppl</a><br>
 * Element description: 6.3.4.E1.3.1 Medication Treatment Plan Item Entry General Specification<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.34<br>
 * Effective date: 2019-12-11 11:31:52<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class MedicationTreatmentPlanEntryContentModule extends POCDMT000040SubstanceAdministration {

    public MedicationTreatmentPlanEntryContentModule() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(org.husky.emed.cda.generated.hl7cdar2.XDocumentSubstanceMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.34"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.7"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7"));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void addHl7ApproachSiteCode(org.husky.emed.cda.generated.hl7cdar2.CD value) {
        getApproachSiteCode().add(value);
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void clearHl7ApproachSiteCode() {
        getApproachSiteCode().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.husky.emed.cda.generated.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.IVLPQ retVal = factory.createIVLPQ();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param operator the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.EIVLTS createHl7EffectiveTimeFixedValue(String operator) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.EIVLTS retVal = factory.createEIVLTS();
        retVal.setOperator(org.husky.emed.cda.generated.hl7cdar2.SetOperator.fromValue(operator));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.husky.emed.cda.generated.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
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
    private static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Reference createHl7ReferenceFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Reference retVal = factory.createPOCDMT000040Reference();
        retVal.setTypeCode(org.husky.emed.cda.generated.hl7cdar2.XActRelationshipExternalReference.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RepeatNumber
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.IVLINT createHl7RepeatNumberFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.IVLINT retVal = factory.createIVLINT();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RouteCode
     */
    private static org.husky.emed.cda.generated.hl7cdar2.CE createHl7RouteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Author
     * Medication Treatment Plan Author
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Consumable
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
        return consumable;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.husky.emed.cda.generated.hl7cdar2.IVLPQ getHl7DoseQuantity() {
        return doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime
     * <div>In case the (structured) dosage instructions include a dose regime this element SHALL be</div><div>present and specify the entire duration of the medication treatment. In case the Duration of Treatment is unknown the &lt;low&gt; and &lt;high&gt; sub-elements of this element SHALL be set to null flavor “UNK”.</div>
     */
    public List<SXCMTS> getHl7EffectiveTimeListSxcmts() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EntryRelationship
     * IHE MTP Reason. Referencing to the Treatment Reason Entry Content Module below (required by IHE PHARM)
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7Id
     * Medication Treatment Plan Item ID
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Precondition
     * Precondition Criterion
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Precondition> getHl7Precondition() {
        return precondition;
    }

    /**
     * Gets the hl7RateQuantity
     */
    public org.husky.emed.cda.generated.hl7cdar2.IVLPQ getHl7RateQuantity() {
        return rateQuantity;
    }

    /**
     * Gets the hl7Reference
     * ID of parent container (Community Medication Treatment Plan document)
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
        return reference;
    }

    /**
     * Gets the hl7RepeatNumber
     * Number of repeats/refills. Either the @value or @nullFlavor attribute shall be set. It's required in MTP, PRE and PADV items ; forbidden in DIS items.
     */
    public org.husky.emed.cda.generated.hl7cdar2.IVLINT getHl7RepeatNumber() {
        return repeatNumber;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.husky.emed.cda.generated.hl7cdar2.CE getHl7RouteCode() {
        return routeCode;
    }

    /**
     * Gets the hl7StatusCode
     * Status Code
     */
    public org.husky.emed.cda.generated.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     * CH-PHARM Medication Treatment Plan Item Entry Content Module
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.husky.emed.cda.generated.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.EIVLTS, filled by: "A"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.EIVLTS getPredefinedEffectiveTimeA() {
        return createHl7EffectiveTimeFixedValue("A");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "COMP", null
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipCompNull() {
        return createHl7EntryRelationshipFixedValue("COMP",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", null
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "RSON", null
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRsonNull() {
        return createHl7EntryRelationshipFixedValue("RSON",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "SUBJ", "true"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjTrue() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    "true");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Reference, filled by: "XCRPT"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Reference getPredefinedReferenceXcrpt() {
        return createHl7ReferenceFixedValue("XCRPT");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.IVLINT, filled by: "NI"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.IVLINT getPredefinedRepeatNumberNi() {
        return createHl7RepeatNumberFixedValue("NI");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.CE getPredefinedRouteCode() {
        return createHl7RouteCodeFixedValue();
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.7.1"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.II getPredefinedTemplateId136141193761531471() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.8"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.II getPredefinedTemplateId13614119376153148() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.8");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.9"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.II getPredefinedTemplateId13614119376153149() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9");
    }

    /**
     * Sets the hl7Author
     * Medication Treatment Plan Author
     */
    public void setHl7Author(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Consumable
     */
    public void setHl7Consumable(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Consumable value) {
        this.consumable = value;
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.husky.emed.cda.generated.hl7cdar2.IVLPQ value) {
        this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime
     * <div>In case the (structured) dosage instructions include a dose regime this element SHALL be</div><div>present and specify the entire duration of the medication treatment. In case the Duration of Treatment is unknown the &lt;low&gt; and &lt;high&gt; sub-elements of this element SHALL be set to null flavor “UNK”.</div>
     */
    public void setHl7EffectiveTime(org.husky.emed.cda.generated.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EffectiveTime
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Event based time interval, where the event is not a precise time, but is used for timing purposes (e.g., with meals, between meals, before breakfast, before sleep).
     */
    public void setHl7EffectiveTime(org.husky.emed.cda.generated.hl7cdar2.EIVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EffectiveTime
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Multiple events within a day with the same dosage
     */
    public void setHl7EffectiveTime(org.husky.emed.cda.generated.hl7cdar2.SXPRTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EntryRelationship
     * IHE MTP Reason. Referencing to the Treatment Reason Entry Content Module below (required by IHE PHARM)
     */
    public void setHl7EntryRelationship(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7Id
     * Medication Treatment Plan Item ID
     */
    public void setHl7Id(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Precondition
     * Precondition Criterion
     */
    public void setHl7Precondition(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Precondition value) {
        getPrecondition().clear();
        getPrecondition().add(value);
    }

    /**
     * Sets the hl7RateQuantity
     */
    public void setHl7RateQuantity(org.husky.emed.cda.generated.hl7cdar2.IVLPQ value) {
        this.rateQuantity = value;
    }

    /**
     * Sets the hl7Reference
     * ID of parent container (Community Medication Treatment Plan document)
     */
    public void setHl7Reference(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Reference value) {
        getReference().clear();
        getReference().add(value);
    }

    /**
     * Sets the hl7RepeatNumber
     * Number of repeats/refills. Either the @value or @nullFlavor attribute shall be set. It's required in MTP, PRE and PADV items ; forbidden in DIS items.
     */
    public void setHl7RepeatNumber(org.husky.emed.cda.generated.hl7cdar2.IVLINT value) {
        this.repeatNumber = value;
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.husky.emed.cda.generated.hl7cdar2.CE value) {
        this.routeCode = value;
    }

    /**
     * Sets the hl7StatusCode
     * Status Code
     */
    public void setHl7StatusCode(org.husky.emed.cda.generated.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     * CH-PHARM Medication Treatment Plan Item Entry Content Module
     */
    public void setHl7TemplateId(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.husky.emed.cda.generated.hl7cdar2.ED value) {
        this.text = value;
    }
}
