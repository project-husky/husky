/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organizer;
import org.projecthusky.common.hl7cdar2.XActClassDocumentEntryOrganizer;

/**
 * epims_entry_OrganizerBetreuung
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.106<br>
 * Effective date: 2020-07-25 14:39:43<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryOrganizerBetreuung extends POCDMT000040Organizer {

    public EpimsEntryOrganizerBetreuung() {
		super.setClassCode(XActClassDocumentEntryOrganizer.BATTERY);
		super.getMoodCode().add("EVN");
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.106"));
		super.setCode(
				createHl7CodeFixedValue("50", "1.2.40.0.34.5.189", "EMS_struktur_elemente", "EMS_Organizer_Betreuung"));
		super.setStatusCode(createHl7StatusCodeFixedValue("completed", null, null, null));
		super.getComponent().add(createHl7ComponentFixedValue("COMP"));
    }

    /**
     * Adds a hl7Component
     */
	public void addHl7Component(org.projecthusky.common.hl7cdar2.POCDMT000040Component4 value) {
        getComponent().add(value);
    }

    /**
     * Adds a hl7Component
     */
    public void clearHl7Component() {
        getComponent().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
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
     */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040Component4 createHl7ComponentFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
		org.projecthusky.common.hl7cdar2.POCDMT000040Component4 retVal = factory.createPOCDMT000040Component4();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        org.projecthusky.common.hl7cdar2.CS retVal = new org.projecthusky.common.hl7cdar2.CS();
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
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
	public org.projecthusky.common.hl7cdar2.CD getHl7Code() {
		return this.code;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
		return this.statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by: "50", "1.2.40.0.34.5.189", null, null
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedCode5012400345189NullNull() {
        return createHl7CodeFixedValue("50",
                                       "1.2.40.0.34.5.189",
                                       null,
                                       null);
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by: "EMS_struktur_elemente", "EMS_Organizer_Betreuung", null, null
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedCodeEmsStrukturElementeEmsOrganizerBetreuungNullNull() {
        return createHl7CodeFixedValue("EMS_struktur_elemente",
                                       "EMS_Organizer_Betreuung",
                                       null,
                                       null);
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.projecthusky.common.hl7cdar2.CS value) {
        // TODO: NYI
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
