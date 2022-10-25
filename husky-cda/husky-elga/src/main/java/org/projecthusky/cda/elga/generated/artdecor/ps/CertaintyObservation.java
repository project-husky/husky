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
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.XActMoodDocumentObservation;

/**
 * CertaintyObservation
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.19<br>
 * Effective date: 2017-08-10 20:25:54<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class CertaintyObservation extends POCDMT000040Observation {

    public CertaintyObservation() {
		super.getClassCode().add("OBS");
		super.setMoodCode(XActMoodDocumentObservation.EVN);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.13.3.19"));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed",
                                                          null,
                                                          null,
                                                          null));
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        org.projecthusky.common.hl7cdar2.CS retVal = new org.projecthusky.common.hl7cdar2.CS();
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
        org.projecthusky.common.hl7cdar2.II retVal = new org.projecthusky.common.hl7cdar2.II();
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
     * Gets the hl7StatusCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
		return this.statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
	public List<II> getHl7TemplateId() {
		return this.templateId;
    }

    /**
     * Gets the hl7Text
     */
	public org.projecthusky.common.hl7cdar2.ED getHl7Text() {
		return this.text;
    }

    /**
     * Gets the hl7Value
     */
	public List<ANY> getHl7Value() {
		return this.value;
    }

    /**
     * Sets the hl7Code
     */
	public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
		this.code = value;
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
		this.templateId.clear();
		this.templateId.add(value);
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
		this.value.clear();
		this.value.add(value);
    }
}
