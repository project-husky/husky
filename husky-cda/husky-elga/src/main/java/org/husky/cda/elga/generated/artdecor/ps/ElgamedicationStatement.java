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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.SXCMTS;
import org.husky.common.model.Code;

/**
 * ELGAMedicationStatement
 * Identifier: 1.2.40.0.34.11.13.3.27<br>
 * Effective date: 2018-10-18 11:16:13<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class ElgamedicationStatement extends POCDMT000040SubstanceAdministration {

    public ElgamedicationStatement() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.27"));
        super.setCode(createHl7CodeFixedValue());
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("active").build()));
        statusCode = (new Code(CodeBaseType.builder().withCode("active").build())).getHl7CdaR2Cs();
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

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
     * Adds a hl7Reference
     */
    public void addHl7Reference(org.husky.common.hl7cdar2.POCDMT000040Reference value) {
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
     * Adds a hl7Reference
     */
    public void clearHl7Reference() {
        getReference().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
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
        return (org.husky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public List<SXCMTS> getHl7EffectiveTime() {
        return effectiveTime;
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
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
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
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
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
}
