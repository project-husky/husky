/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Observation;

/**
 * atcdabbr_entry_ExpositionsrisikoProblem
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.21<br>
 * Effective date: 2022-01-26 16:08:41<br>
 * Version: 1.1.0+20220127<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrEntryExpositionsrisikoProblem extends POCDMT000040Observation {

    public AtcdabbrEntryExpositionsrisikoProblem() {
        super.getClassCode().add("OBS");
        super.setMoodCode(org.husky.common.hl7cdar2.XActMoodDocumentObservation.EVN);
		super.setNegationInd(Boolean.FALSE);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.21"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.28"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
        super.setCode(createHl7CodeFixedValue("55607006",
                                              "2.16.840.1.113883.6.96",
                                              null,
                                              null));
        super.setCode(createHl7CodeFixedValue("SNOMED CT",
                                              null,
                                              null,
                                              null));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed",
                                                          null,
                                                          null,
                                                          null));
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Participant
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextControlCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Participant2 createHl7ParticipantFixedValue(String typeCode, String contextControlCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Participant2 retVal = factory.createPOCDMT000040Participant2();
        retVal.getTypeCode().add(typeCode);
        retVal.setContextControlCode(contextControlCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CS retVal = factory.createCS();
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
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Value
     */
    private static org.husky.common.hl7cdar2.CD createHl7ValueFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CD retVal = factory.createCD();
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CE getHl7Code() {
        return (org.husky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.husky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
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
     * Gets the hl7Value
     */
    public List<ANY> getHl7Value() {
        return value;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by: "55607006", "2.16.840.1.113883.6.96", null, null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedCode556070062168401113883696NullNull() {
        return createHl7CodeFixedValue("55607006",
                                       "2.16.840.1.113883.6.96",
                                       null,
                                       null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by: "SNOMED CT", null, null, null
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedCodeSnomedCtNullNullNull() {
        return createHl7CodeFixedValue("SNOMED CT",
                                       null,
                                       null,
                                       null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Participant2, filled by: "AUT", "OP"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantAutOp() {
        return createHl7ParticipantFixedValue("AUT",
                                              "OP");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Participant2, filled by: "ENT", "OP"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantEntOp() {
        return createHl7ParticipantFixedValue("ENT",
                                              "OP");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Participant2, filled by: "VRF", "OP"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Participant2 getPredefinedParticipantVrfOp() {
        return createHl7ParticipantFixedValue("VRF",
                                              "OP");
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.husky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
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

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.CD value) {
        getValue().clear();
        getValue().add(value);
    }
}
