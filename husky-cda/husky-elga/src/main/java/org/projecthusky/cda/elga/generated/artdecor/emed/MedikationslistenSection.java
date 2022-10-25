/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Section;

/**
 * MedikationslistenSection
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.8.3.2.1<br>
 * Effective date: 2014-01-31 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class MedikationslistenSection extends POCDMT000040Section {

    public MedikationslistenSection() {
        super.getClassCode().add("DOCSECT");
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.8.3.2.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.2.5"));
        super.setCode(createHl7CodeFixedValue("10160-0",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "History of medication use"));
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
