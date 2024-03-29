/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040ExternalDocument;

/**
 * atcdabbr_entry_externalDocument
 * 
 * Identifier: 1.2.40.0.34.6.0.11.3.14<br>
 * Effective date: 2021-02-19 12:43:40<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrEntryExternalDocument extends POCDMT000040ExternalDocument {

    public AtcdabbrEntryExternalDocument() {
        super.setClassCode("DOC");
		super.getMoodCode().add("EVN");
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.14"));
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
     * Gets the hl7Id
     */
	public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
		return this.id;
    }

    /**
     * Gets the hl7SetId
     */
    public org.projecthusky.common.hl7cdar2.II getHl7SetId() {
		return this.setId;
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
    public org.projecthusky.common.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Gets the hl7VersionNumber
     */
    public org.projecthusky.common.hl7cdar2.INT getHl7VersionNumber() {
		return this.versionNumber;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
		this.code = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
    }

    /**
     * Sets the hl7SetId
     */
    public void setHl7SetId(org.projecthusky.common.hl7cdar2.II value) {
		this.setId = value;
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
    public void setHl7Text(org.projecthusky.common.hl7cdar2.ED value) {
        this.text = value;
    }

    /**
     * Sets the hl7VersionNumber
     */
    public void setHl7VersionNumber(org.projecthusky.common.hl7cdar2.INT value) {
		this.versionNumber = value;
    }
}
