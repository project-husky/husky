/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base;

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Laborbefund
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.4<br>
 * Effective date: 2015-09-24 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class Laborbefund extends POCDMT000040ClinicalDocument {

    public Laborbefund() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.4"));
        super.setCode(createHl7CodeFixedValue("11502-2",
                                              "2.16.840.1.113883.6.1",
                                              null,
                                              "Laboratory report"));
    }

    /**
     * Adds a hl7DocumentationOf
     */
    public void addHl7DocumentationOf(org.husky.common.hl7cdar2.POCDMT000040DocumentationOf value) {
        getDocumentationOf().add(value);
    }

    /**
     * Adds a hl7DocumentationOf
     */
    public void clearHl7DocumentationOf() {
        getDocumentationOf().clear();
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
     * Creates fixed contents for CDA Element hl7Component
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextConductionInd the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Component2 createHl7ComponentFixedValue(String typeCode, String contextConductionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Component2 retVal = factory.createPOCDMT000040Component2();
        retVal.setTypeCode(org.husky.common.hl7cdar2.ActRelationshipHasComponent.fromValue(typeCode));
        if (contextConductionInd != null) {
            retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Participant
     *
     * @param typeCode the desired fixed value for this argument.
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Participant1 createHl7ParticipantFixedValue(String typeCode, String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Participant1 retVal = factory.createPOCDMT000040Participant1();
        retVal.getTypeCode().add(typeCode);

		if (nullFlavor != null) {
			retVal.getNullFlavor().add(nullFlavor);
		}

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
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Component
     */
    public org.husky.common.hl7cdar2.POCDMT000040Component2 getHl7Component() {
        return component;
    }

    /**
     * Gets the hl7Id
     */
    public org.husky.common.hl7cdar2.II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Participant1> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Title
     */
    public org.husky.common.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Component2, filled by: "COMP", "true"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Component2 getPredefinedComponentCompTrue() {
        return createHl7ComponentFixedValue("COMP",
                                            "true");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Participant1, filled by: "REF"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Participant1 getPredefinedParticipantRef() {
		return createHl7ParticipantFixedValue("REF", null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Participant1, filled by: "REF", "UNK"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Participant1 getPredefinedParticipantRefUnk() {
        return createHl7ParticipantFixedValue("REF",
                                              "UNK");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.2.40.0.34.11.4.0.1"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId124003411401() {
        return createHl7TemplateIdFixedValue("1.2.40.0.34.11.4.0.1");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.2.40.0.34.11.4.0.2"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId124003411402() {
        return createHl7TemplateIdFixedValue("1.2.40.0.34.11.4.0.2");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.2.40.0.34.11.4.0.3"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedTemplateId124003411403() {
        return createHl7TemplateIdFixedValue("1.2.40.0.34.11.4.0.3");
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7Component
     */
    public void setHl7Component(org.husky.common.hl7cdar2.POCDMT000040Component2 value) {
        this.component = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        this.id = value;
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.husky.common.hl7cdar2.POCDMT000040Participant1 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Title
     */
    public void setHl7Title(org.husky.common.hl7cdar2.ST value) {
        this.title = value;
    }
}
