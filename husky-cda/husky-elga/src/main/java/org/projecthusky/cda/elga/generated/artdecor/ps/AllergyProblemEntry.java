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

import org.projecthusky.common.hl7cdar2.ANY;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;

/**
 * AllergyProblemEntry
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.2<br>
 * Effective date: 2016-11-06 17:03:02<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class AllergyProblemEntry extends POCDMT000040Observation {

    public AllergyProblemEntry() {
        super.getClassCode().add("OBS");
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.2"));
        super.setCode(createHl7CodeFixedValue());
        super.setStatusCode(createHl7StatusCodeFixedValue("completed",
                                                          null,
                                                          null,
                                                          null));
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Id
     */
    public void clearHl7Id() {
        getId().clear();
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
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CS retVal = factory.createCS();
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
     * Gets the hl7Value
     */
    public List<ANY> getHl7Value() {
        return value;
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

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.projecthusky.common.hl7cdar2.ANY value) {
        getValue().clear();
        getValue().add(value);
    }
}
