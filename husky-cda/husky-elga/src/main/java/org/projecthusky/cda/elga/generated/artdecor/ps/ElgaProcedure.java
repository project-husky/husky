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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Procedure;
import org.projecthusky.common.model.Code;

/**
 * ELGA_Procedure
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.5<br>
 * Effective date: 2017-01-28 14:53:47<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class ElgaProcedure extends POCDMT000040Procedure {

    public ElgaProcedure() {
        super.getClassCode().add("PROC");
        vocabProcedureMoodCode.add(new Code(CodeBaseType.builder().withCode("EVN").build()));
        vocabProcedureMoodCode.add(new Code(CodeBaseType.builder().withCode("INT").build()));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.5"));
        super.setCode(createHl7CodeFixedValue());
    }

    private final List<Code> vocabProcedureMoodCode = new ArrayList<>();

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void addHl7ApproachSiteCode(org.projecthusky.common.hl7cdar2.CE value) {
        getApproachSiteCode().add(value);
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
     * Adds a hl7MethodCode
     */
    public void addHl7MethodCode(org.projecthusky.common.hl7cdar2.CE value) {
        getMethodCode().add(value);
    }

    /**
     * Adds a hl7TargetSiteCode
     */
    public void addHl7TargetSiteCode(org.projecthusky.common.hl7cdar2.CE value) {
        getTargetSiteCode().add(value);
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void clearHl7ApproachSiteCode() {
        getApproachSiteCode().clear();
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
     * Adds a hl7MethodCode
     */
    public void clearHl7MethodCode() {
        getMethodCode().clear();
    }

    /**
     * Adds a hl7TargetSiteCode
     */
    public void clearHl7TargetSiteCode() {
        getTargetSiteCode().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7ApproachSiteCode
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7ApproachSiteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7MethodCode
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7MethodCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TargetSiteCode
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7TargetSiteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
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
        return (org.projecthusky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.projecthusky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Reference
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
        return reference;
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
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedApproachSiteCode() {
        return createHl7ApproachSiteCodeFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedMethodCode() {
        return createHl7MethodCodeFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedTargetSiteCode() {
        return createHl7TargetSiteCodeFixedValue();
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabProcedureMoodCode() {
        return vocabProcedureMoodCode;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.projecthusky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().clear();
        getReference().add(value);
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
}
