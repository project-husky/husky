/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ANY;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.XActMoodDocumentObservation;

/**
 * eimpf_entry_ImpfrelevanteErkrankungProblemEntry
 * Identifier: 1.2.40.0.34.6.0.11.3.9<br>
 * Effective date: 2022‑01‑25 14:24:26<br>
 * Version: 1.1.0+20220127<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class EimpfEntryImpfrelevanteErkrankungProblemEntry extends POCDMT000040Observation {

    public EimpfEntryImpfrelevanteErkrankungProblemEntry() {
		super.getClassCode().add("OBS");
		super.setMoodCode(XActMoodDocumentObservation.EVN);
		super.setNegationInd(false);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.9"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.28"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
		super.setCode(createHl7CodeFixedValue("55607006", "2.16.840.1.113883.6.96", "SNOMED CT", null));
		super.setStatusCode(new CS("completed"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     * @param codeSystem the desired fixed value for this argument.
     * @param codeSystemName the desired fixed value for this argument.
     * @param displayName the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
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
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
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
	 * Gets the hl7Id
	 */
	public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7Participant
	 */
	public List<org.projecthusky.common.hl7cdar2.POCDMT000040Participant2> getHl7Participant() {
		return participant;
	}

	/**
	 * Gets the hl7StatusCode
	 */
	public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
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
	 * Sets the hl7Id
	 */
	public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7Participant
	 */
	public void setHl7Participant(org.projecthusky.common.hl7cdar2.POCDMT000040Participant2 value) {
		getParticipant().clear();
		getParticipant().add(value);
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
	public void setHl7Value(org.projecthusky.common.hl7cdar2.CD value) {
		getValue().clear();
		getValue().add(value);
	}


}
