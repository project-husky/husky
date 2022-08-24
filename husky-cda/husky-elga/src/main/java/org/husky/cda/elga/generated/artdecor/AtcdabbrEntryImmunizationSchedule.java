/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Criterion;

/**
 * atcdabbr_entry_ImmunizationTarget
 * 
 * Identifier: 1.2.40.0.34.6.0.11.3.2<br>
 * Effective date: 2021‑10‑28 13:49:14<br>
 * Version: 1.0.1+20220103<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrEntryImmunizationSchedule extends POCDMT000040Criterion {

    public AtcdabbrEntryImmunizationSchedule() {
		super.getClassCode().add("OBS");
		super.getMoodCode().add("EVN.CRT");
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.10"));
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
	public CD getHl7Code() {
        return code;
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
	public ED getHl7Text() {
		return text;
	}

	/**
	 * Gets the hl7Value
	 */
	public ANY getHl7Value() {
		return value;
	}

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CD value) {
        this.code = value;
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

	/**
	 * Sets the hl7Value
	 */
	public void setHl7Value(org.husky.common.hl7cdar2.ANY value) {
		this.value = value;
	}
}
