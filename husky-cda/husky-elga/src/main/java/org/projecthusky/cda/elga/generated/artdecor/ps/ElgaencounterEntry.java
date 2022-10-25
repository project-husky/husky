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
import org.projecthusky.common.hl7cdar2.POCDMT000040Encounter;

/**
 * ELGAEncounterEntry
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.28<br>
 * Effective date: 2018-10-18 17:20:23<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class ElgaencounterEntry extends POCDMT000040Encounter {

    public ElgaencounterEntry() {
        super.getClassCode().add("ENC");
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XDocumentEncounterMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.28"));
        super.setCode(createHl7CodeFixedValue());
    }

    /**
     * Adds a hl7Author
     */
    public void addHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Informant
     */
    public void addHl7Informant(org.projecthusky.common.hl7cdar2.POCDMT000040Informant12 value) {
        getInformant().add(value);
    }

    /**
     * Adds a hl7Performer
     */
    public void addHl7Performer(org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 value) {
        getPerformer().add(value);
    }

    /**
     * Adds a hl7Reference
     */
    public void addHl7Reference(org.projecthusky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().add(value);
    }

    /**
     * Adds a hl7Author
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Adds a hl7Id
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Adds a hl7Informant
     */
    public void clearHl7Informant() {
        getInformant().clear();
    }

    /**
     * Adds a hl7Performer
     */
    public void clearHl7Performer() {
        getPerformer().clear();
    }

    /**
     * Adds a hl7Reference
     */
    public void clearHl7Reference() {
        getReference().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.projecthusky.common.hl7cdar2.CD createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CD retVal = factory.createCD();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CS retVal = factory.createCS();
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
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.projecthusky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
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
     * Adds a predefined org.projecthusky.common.hl7cdar2.CS, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CS getPredefinedStatusCode() {
        return createHl7StatusCodeFixedValue();
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.projecthusky.common.hl7cdar2.CS value) {
        this.statusCode = value;
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
}
