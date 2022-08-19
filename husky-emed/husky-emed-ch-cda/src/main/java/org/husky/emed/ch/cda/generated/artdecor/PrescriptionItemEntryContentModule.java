/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.SXCMTS;

/**
 * PrescriptionItemEntryContentModule
 * <p>
 * Template description: A Prescription Item belongs to one prescription and represents one prescribed medication. It may be associated with one or more observations. Prescription Item is the atomic entity for logistics, distribution and billing. It contains the prescribed medicine and dosage information as well as other information to the prescribed item such as patient- and fulfillment instructions and substitution handling.<br>
 * Element description: Prescription Item Entry Additional Template ID<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.43<br>
 * Effective date: 2019-09-11 17:05:49<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class PrescriptionItemEntryContentModule extends POCDMT000040SubstanceAdministration {

    public PrescriptionItemEntryContentModule() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.43"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.6"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7"));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void addHl7ApproachSiteCode(org.husky.common.hl7cdar2.CD value) {
        getApproachSiteCode().add(value);
    }

    /**
     * Adds a hl7Reference
     */
    public void addHl7Reference(org.husky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().add(value);
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void clearHl7ApproachSiteCode() {
        getApproachSiteCode().clear();
    }

    /**
     * Adds a hl7Reference
     */
    public void clearHl7Reference() {
        getReference().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.husky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.IVLPQ retVal = factory.createIVLPQ();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param operator the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.EIVLTS createHl7EffectiveTimeFixedValue(String operator) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.EIVLTS retVal = factory.createEIVLTS();
        retVal.setOperator(org.husky.common.hl7cdar2.SetOperator.fromValue(operator));
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
     * Creates fixed contents for CDA Element hl7RepeatNumber
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.IVLINT createHl7RepeatNumberFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.IVLINT retVal = factory.createIVLINT();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RouteCode
     */
    private static org.husky.common.hl7cdar2.CE createHl7RouteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
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
     * Gets the hl7Consumable
     */
    public org.husky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
        return consumable;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.husky.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
        return doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime<br/>
     * <div>In case the (structured) dosage instructions include a dose regime this element SHALL be</div><div>present and specify the entire duration of the medication treatment. In case the Duration of Treatment is unknown the &lt;low&gt; and &lt;high&gt; sub-elements of this element SHALL be set to null flavor “UNK”.</div>
     */
    public List<SXCMTS> getHl7EffectiveTimeListSxcmts() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EntryRelationship<br/>
     * Treatment Reason as text
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7Id<br/>
     * This ID represents the Prescription Item ID and SHALL be present.
     */
    public List<org.husky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Precondition<br/>
     * Precondition Criterion
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Precondition> getHl7Precondition() {
        return precondition;
    }

    /**
     * Gets the hl7RateQuantity
     */
    public org.husky.common.hl7cdar2.IVLPQ getHl7RateQuantity() {
        return rateQuantity;
    }

    /**
     * Gets the hl7RepeatNumber<br/>
     * Number of repeats/refills. Either the {@literal @}value or {@literal @}nullFlavor attribute shall be set. It's required in MTP, PRE and PADV (changed MTP, changed/recommended PRE) items ; forbidden in DIS and PADV (changed dosage instructions) items.
     */
    public org.husky.common.hl7cdar2.IVLINT getHl7RepeatNumber() {
        return repeatNumber;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.husky.common.hl7cdar2.CE getHl7RouteCode() {
        return routeCode;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId<br/>
     * CH-PHARM Prescription Item Entry Content Module
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text<br/>
     * Narrative Text
     */
    public org.husky.common.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.EIVLTS, filled by: "A"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.EIVLTS getPredefinedEffectiveTimeA() {
        return createHl7EffectiveTimeFixedValue("A");
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
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "RSON", null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRsonNull() {
        return createHl7EntryRelationshipFixedValue("RSON",
                                                    null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "SUBJ", "true"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjTrue() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    "true");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Reference, filled by: "XCRPT"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Reference getPredefinedReferenceXcrpt() {
        return createHl7ReferenceFixedValue("XCRPT");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.IVLINT, filled by: "NI"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.IVLINT getPredefinedRepeatNumberNi() {
        return createHl7RepeatNumberFixedValue("NI");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedRouteCode() {
        return createHl7RouteCodeFixedValue();
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.7.1"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId136141193761531471() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.8"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId13614119376153148() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.8");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.9"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId13614119376153149() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9");
    }

    /**
     * Sets the hl7Consumable
     */
    public void setHl7Consumable(org.husky.common.hl7cdar2.POCDMT000040Consumable value) {
        this.consumable = value;
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.husky.common.hl7cdar2.IVLPQ value) {
        this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * <div>In case the (structured) dosage instructions include a dose regime this element SHALL be</div><div>present and specify the entire duration of the medication treatment. In case the Duration of Treatment is unknown the &lt;low&gt; and &lt;high&gt; sub-elements of this element SHALL be set to null flavor “UNK”.</div>
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Event based time interval, where the event is not a precise time, but is used for timing purposes (e.g., with meals, between meals, before breakfast, before sleep).
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.EIVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Multiple events within a day with the same dosage
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.SXPRTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EntryRelationship<br/>
     * Treatment Reason as text
     */
    public void setHl7EntryRelationship(org.husky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7Id<br/>
     * This ID represents the Prescription Item ID and SHALL be present.
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Precondition<br/>
     * Precondition Criterion
     */
    public void setHl7Precondition(org.husky.common.hl7cdar2.POCDMT000040Precondition value) {
        getPrecondition().clear();
        getPrecondition().add(value);
    }

    /**
     * Sets the hl7RateQuantity
     */
    public void setHl7RateQuantity(org.husky.common.hl7cdar2.IVLPQ value) {
        this.rateQuantity = value;
    }

    /**
     * Sets the hl7RepeatNumber<br/>
     * Number of repeats/refills. Either the {@literal @}value or {@literal @}nullFlavor attribute shall be set. It's required in MTP, PRE and PADV (changed MTP, changed/recommended PRE) items ; forbidden in DIS and PADV (changed dosage instructions) items.
     */
    public void setHl7RepeatNumber(org.husky.common.hl7cdar2.IVLINT value) {
        this.repeatNumber = value;
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.husky.common.hl7cdar2.CE value) {
        this.routeCode = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId<br/>
     * CH-PHARM Prescription Item Entry Content Module
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text<br/>
     * Narrative Text
     */
    public void setHl7Text(org.husky.common.hl7cdar2.ED value) {
        this.text = value;
    }
}
