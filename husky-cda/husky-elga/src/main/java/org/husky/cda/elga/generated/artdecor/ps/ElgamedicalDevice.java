/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ps;

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Supply;
import org.husky.common.hl7cdar2.SXCMTS;

/**
 * ELGAMedicalDevice
 * Identifier: 1.2.40.0.34.11.13.3.8<br>
 * Effective date: 2017-02-26 11:17:52<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class ElgamedicalDevice extends POCDMT000040Supply {

    public ElgamedicalDevice() {
        super.setClassCode(org.husky.common.hl7cdar2.ActClassSupply.SPLY);
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.8"));
        super.getParticipant().add(createHl7ParticipantFixedValue("DEV"));
    }

    /**
     * Adds a hl7Author
     */
    public void addHl7Author(org.husky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Informant
     */
    public void addHl7Informant(org.husky.common.hl7cdar2.POCDMT000040Informant12 value) {
        getInformant().add(value);
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
     * Creates fixed contents for CDA Element hl7Participant
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Participant2 createHl7ParticipantFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Participant2 retVal = factory.createPOCDMT000040Participant2();
        retVal.getTypeCode().add(typeCode);
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
     * Gets the hl7EffectiveTime
     */
    public List<SXCMTS> getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Participant
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
        return participant;
    }

    /**
     * Gets the hl7Reference
     */
    public List<org.husky.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
        return reference;
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
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7Participant
     */
    public void setHl7Participant(org.husky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().clear();
        getParticipant().add(value);
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.husky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().clear();
        getReference().add(value);
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
}
