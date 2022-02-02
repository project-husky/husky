/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.SXCMTS;

/**
 * epims_entry_EMSImmunization
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.97<br>
 * Effective date: 2020-05-11 16:37:29<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryEmsimmunization extends POCDMT000040SubstanceAdministration {

    public EpimsEntryEmsimmunization() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.EVN);
		super.setNegationInd(Boolean.FALSE);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.97"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
        super.setCode(createHl7CodeFixedValue());
        super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
        super.setRouteCode(createHl7RouteCodeFixedValue("NA"));
        super.getApproachSiteCode().add(createHl7ApproachSiteCodeFixedValue("NA"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ApproachSiteCode
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CD createHl7ApproachSiteCodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CD retVal = factory.createCD();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.husky.common.hl7cdar2.CD createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CD retVal = factory.createCD();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.husky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.IVLPQ retVal = factory.createIVLPQ();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.TS createHl7EffectiveTimeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.TS retVal = factory.createTS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RouteCode
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CE createHl7RouteCodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
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
     * Gets the hl7ApproachSiteCode
     */
    public List<org.husky.common.hl7cdar2.CD> getHl7ApproachSiteCode() {
        return approachSiteCode;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.husky.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
        return doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public List<SXCMTS> getHl7EffectiveTimeListSxcmts() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.husky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.husky.common.hl7cdar2.CE getHl7RouteCode() {
        return routeCode;
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
     * Gets the hl7Text
     */
    public org.husky.common.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.TS, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.TS getPredefinedEffectiveTimeUnk() {
        return createHl7EffectiveTimeFixedValue("UNK");
    }

    /**
     * Sets the hl7ApproachSiteCode
     */
    public void setHl7ApproachSiteCode(org.husky.common.hl7cdar2.CD value) {
        getApproachSiteCode().clear();
        getApproachSiteCode().add(value);
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.husky.common.hl7cdar2.IVLPQ value) {
        this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
	public void setHl7EffectiveTime(org.husky.common.hl7cdar2.SXCMTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.husky.common.hl7cdar2.CE value) {
        this.routeCode = value;
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

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.husky.common.hl7cdar2.ED value) {
        this.text = value;
    }
}
