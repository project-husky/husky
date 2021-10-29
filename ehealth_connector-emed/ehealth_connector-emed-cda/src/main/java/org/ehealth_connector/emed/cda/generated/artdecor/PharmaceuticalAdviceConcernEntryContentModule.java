package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Act;

/**
 * PharmaceuticalAdviceConcernEntryContentModule
 * <p>
 * Template description: A Pharmaceutical Advice Concern Item belongs to one Pharmaceutical Advice Item and represents the information to concerns (e.g., problems, allergies, etc.) which the Medication Treatment Plan-, Prescription-, Dispense- or Administration Item referenced by the underlying Pharmaceutical Advice Item causes.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.81<br>
 * Effective date: 2016-01-11 11:13:04<br>
 * Version: 2017<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class PharmaceuticalAdviceConcernEntryContentModule extends POCDMT000040Act {

    public PharmaceuticalAdviceConcernEntryContentModule() {
        super.setClassCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.XActClassDocumentEntryAct.ACT);
        super.setMoodCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.XDocumentActMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.81"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.27"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.5"));
        super.setCode(createHl7CodeFixedValue("NA"));
        super.setStatusCode(createHl7StatusCodeFixedValue("active",
                                                          null,
                                                          null,
                                                          null));
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.CD createHl7CodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.CD retVal = factory.createCD();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
        if (inversionInd != null) {
            retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     * An optional narrative description of the concern
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     * Problems determined
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EntryRelationship
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7Id
     * Pharmaceutical Advice Concern ID
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7StatusCode
     * Status Code
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     * CH-PHARM Pharmaceutical Advice Concern Entry TemplateID
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     * It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br clear="none"/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", "false"
     * @return the predefined element.
     */
    public static org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrFalse() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    "false");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "SUBJ", null
     * @return the predefined element.
     */
    public static org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjNull() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "SUBJ", "true"
     * @return the predefined element.
     */
    public static org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjTrue() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    "true");
    }

    /**
     * Sets the hl7Code
     * An optional narrative description of the concern
     */
    public void setHl7Code(org.ehealth_connector.emed.cda.generated.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     * Problems determined
     */
    public void setHl7EffectiveTime(org.ehealth_connector.emed.cda.generated.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7EntryRelationship
     */
    public void setHl7EntryRelationship(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7Id
     * Pharmaceutical Advice Concern ID
     */
    public void setHl7Id(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7StatusCode
     * Status Code
     */
    public void setHl7StatusCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     * CH-PHARM Pharmaceutical Advice Concern Entry TemplateID
     */
    public void setHl7TemplateId(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     * It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br clear="none"/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).
     */
    public void setHl7Text(org.ehealth_connector.emed.cda.generated.hl7cdar2.ED value) {
        this.text = value;
    }
}
