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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood;

/**
 * atcdabbr_entry_ImmunizationImpfungNichtAngegeben
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.28<br>
 * Effective date: 2021-10-28 13:24:48<br>
 * Version: 1.0.1+20210512<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrEntryImmunizationImpfungNichtAngegeben extends POCDMT000040SubstanceAdministration {

    public AtcdabbrEntryImmunizationImpfungNichtAngegeben() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(XDocumentSubstanceMood.fromValue("EVN"));
		super.setNegationInd(java.lang.Boolean.valueOf("false"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.28"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.12"));
		super.setCode(createHl7CodeFixedValue("90351000119108", "2.16.840.1.113883.6.96", "SNOMED CT",
				"Vaccination not done (situation)"));
		super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
		super.getEffectiveTime().add(createHl7EffectiveTimeFixedValue("UNK"));
		super.setRouteCode(createHl7RouteCodeFixedValue("NA"));
		super.getApproachSiteCode().add(createHl7ApproachSiteCodeFixedValue("NA"));
		super.setConsumable(createHl7ConsumableFixedValue("CSM"));

    }

    /**
     * Creates fixed contents for CDA Element hl7ApproachSiteCode
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CD createHl7ApproachSiteCodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CD retVal = factory.createCD();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     * @param codeSystem the desired fixed value for this argument.
     * @param codeSystemName the desired fixed value for this argument.
     * @param displayName the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CD createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CD retVal = factory.createCD();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Consumable
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Consumable createHl7ConsumableFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Consumable retVal = factory.createPOCDMT000040Consumable();
        retVal.getTypeCode().add(typeCode);
        return retVal;
    }

    /**
	 * Creates fixed contents for CDA Element hl7EffectiveTime
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	private static SXCMTS createHl7EffectiveTimeFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		SXCMTS retVal = factory.createSXCMTS();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

    /**
     * Creates fixed contents for CDA Element hl7RouteCode
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7RouteCodeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
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
     * Gets the hl7ApproachSiteCode
     */
    public List<org.projecthusky.common.hl7cdar2.CD> getHl7ApproachSiteCode() {
        return approachSiteCode;
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Consumable
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
        return consumable;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public List<SXCMTS> getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7RouteCode() {
        return routeCode;
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
     * Sets the hl7ApproachSiteCode
     */
    public void setHl7ApproachSiteCode(org.projecthusky.common.hl7cdar2.CD value) {
        getApproachSiteCode().clear();
        getApproachSiteCode().add(value);
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7Consumable
     */
    public void setHl7Consumable(org.projecthusky.common.hl7cdar2.POCDMT000040Consumable value) {
        this.consumable = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.TS value) {
        getEffectiveTime().clear();
		getEffectiveTime().add((SXCMTS) value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.routeCode = value;
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
