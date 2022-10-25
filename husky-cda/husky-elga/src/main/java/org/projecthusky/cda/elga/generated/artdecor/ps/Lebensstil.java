/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps;

import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Section;

/**
 * Lebensstil
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.2.8<br>
 * Effective date: 2017-03-12 11:13:38<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class Lebensstil extends POCDMT000040Section {

    public Lebensstil() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.2.8"));
        super.setCode(createHl7CodeFixedValue("29762-2",
                                              "2.16.840.1.113883.6.1",
                                              null,
                                              null));
    }

    /**
     * Adds a hl7Author
     */
    public void addHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Component
     */
    public void addHl7Component(org.projecthusky.common.hl7cdar2.POCDMT000040Component5 value) {
        getComponent().add(value);
    }

    /**
     * Adds a hl7Informant
     */
    public void addHl7Informant(org.projecthusky.common.hl7cdar2.POCDMT000040Informant12 value) {
        getInformant().add(value);
    }

    /**
     * Adds a hl7Author
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Adds a hl7Component
     */
    public void clearHl7Component() {
        getComponent().clear();
    }

    /**
     * Adds a hl7Informant
     */
    public void clearHl7Informant() {
        getInformant().clear();
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
     * @param contextConductionInd the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Component5 createHl7ComponentFixedValue(String typeCode, String contextConductionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Component5 retVal = factory.createPOCDMT000040Component5();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent.fromValue(typeCode));
        if (contextConductionInd != null) {
            retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Entry
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Entry createHl7EntryFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Entry retVal = factory.createPOCDMT000040Entry();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipEntry.fromValue(typeCode));
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
    public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Entry
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Entry> getHl7Entry() {
        return entry;
    }

    /**
     * Gets the hl7Id
     */
    public org.projecthusky.common.hl7cdar2.II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.projecthusky.common.hl7cdar2.StrucDocText getHl7Text() {
        return text;
    }

    /**
     * Gets the hl7Title
     */
    public org.projecthusky.common.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Component5, filled by: "COMP", "true"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Component5 getPredefinedComponentCompTrue() {
        return createHl7ComponentFixedValue("COMP",
                                            "true");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Entry, filled by: "DRIV"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Entry getPredefinedEntryDriv() {
        return createHl7EntryFixedValue("DRIV");
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7Entry
     */
    public void setHl7Entry(org.projecthusky.common.hl7cdar2.POCDMT000040Entry value) {
        getEntry().clear();
        getEntry().add(value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        this.id = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.projecthusky.common.hl7cdar2.StrucDocText value) {
        this.text = value;
    }

    /**
     * Sets the hl7Title
     */
    public void setHl7Title(org.projecthusky.common.hl7cdar2.ST value) {
        this.title = value;
    }
}
