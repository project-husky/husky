package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Observation;

/**
 * IHEAllergyAndIntoleranceEntry
 * <p>
 * Template description: Allergies and intolerances are special kinds of problems, and so are also recorded in the CDA &lt;observation&gt; element, with classCode='OBS'. They follow the same pattern as the problem entry, with exceptions noted below.Parent TemplateThis is a specialization of the IHE PCC Problem Entry 1.3.6.1.4.1.19376.1.5.3.1.4.5 and of the CCD alert observation template 2.16.840.1.113883.10.20.1.18<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.4.6<br>
 * Effective date: 2013-12-20 00:00:00<br>
 * Version: 2014<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class IheallergyAndIntoleranceEntry extends POCDMT000040Observation {

    public IheallergyAndIntoleranceEntry() {
        super.getClassCode().add("OBS");
        super.setMoodCode(org.husky.emed.cda.generated.hl7cdar2.XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.28"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.6"));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed",
                                                          "2.16.840.1.113883.5.14",
                                                          null,
                                                          null));
    }

    /**
     * Adds a hl7EntryRelationship
     */
    public void addHl7EntryRelationship(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().add(value);
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Value
     * <br clear="none"/>
     */
    public void addHl7Value(org.husky.emed.cda.generated.hl7cdar2.CD value) {
        getValue().add(value);
    }

    /**
     * Adds a hl7EntryRelationship
     */
    public void clearHl7EntryRelationship() {
        getEntryRelationship().clear();
    }

    /**
     * Adds a hl7Id
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Adds a hl7Value
     * <br clear="none"/>
     */
    public void clearHl7Value() {
        getValue().clear();
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
     * Creates fixed contents for CDA Element hl7Participant
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Participant2 createHl7ParticipantFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Participant2 retVal = factory.createPOCDMT000040Participant2();
        retVal.getTypeCode().add(typeCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.CS retVal = factory.createCS();
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
    private static org.husky.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.emed.cda.generated.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.husky.emed.cda.generated.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Participant
     * <br clear="none"/>
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.husky.emed.cda.generated.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
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
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "false", "REFR"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipFalseRefr() {
        return createHl7EntryRelationshipFixedValue("false",
                                                    "REFR");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "MFST", null
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipMfstNull() {
        return createHl7EntryRelationshipFixedValue("MFST",
                                                    null);
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship, filled by: "true", "SUBJ"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipTrueSubj() {
        return createHl7EntryRelationshipFixedValue("true",
                                                    "SUBJ");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Participant2, filled by: "CSM"
     * @return the predefined element.
     */
    public static org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantCsm() {
        return createHl7ParticipantFixedValue("CSM");
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.emed.cda.generated.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.husky.emed.cda.generated.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Participant
     * <br clear="none"/>
     */
    public void setHl7Participant(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.emed.cda.generated.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
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
