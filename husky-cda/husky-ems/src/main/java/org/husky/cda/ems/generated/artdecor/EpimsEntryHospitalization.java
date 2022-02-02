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

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.XActClassDocumentEntryAct;
import org.husky.common.hl7cdar2.XDocumentActMood;

/**
 * epims_entry_hospitalization
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.60<br>
 * Effective date: 2020-11-10 14:38:39<br>
 * Version: 2020.1<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryHospitalization extends POCDMT000040Act {

    public EpimsEntryHospitalization() {
		super.setClassCode(XActClassDocumentEntryAct.ACT);
		super.setMoodCode(XDocumentActMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.60"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.6.3.6"));
		super.setCode(createHl7CodeFixedValue("32485007", "2.16.840.1.113883.6.96", "SNOMED CT",
				"Hospital admission (procedure)"));
    }

    /**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code the desired fixed value for this argument.
	 */
	private static CE createHl7CodeFixedValue(String code, String codeSystem,
			String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		CE retVal = factory.createCE();
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
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
	public org.husky.common.hl7cdar2.CD getHl7Code() {
		return this.code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return this.effectiveTime;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
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
		this.effectiveTime = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
