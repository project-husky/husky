/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.46
 * Template description: Information about a health service describing the context of this CDA document. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST use this template by either reference or specialisation.
 *
 * Element description: Information about a health service describing the context of this CDA document.
 */
public class CdachHeaderHealthService extends org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf {

	public CdachHeaderHealthService() {
		super.getTypeCode().add("DOC");
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.46"));
		super.setServiceEvent(createHl7ServiceEventFixedValue("ACT", "EVN"));
	// cdach_header_HealthService/hl7:documentationOf:cs typeCode = "DOC";
	// cdach_header_HealthService/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.46";
	// cdach_header_HealthService/hl7:serviceEvent:cs classCode = "ACT";
	// cdach_header_HealthService/hl7:serviceEvent:cs moodCode = "EVN";
	}

	@XmlTransient()
	private String myTypeCode;

	/**
	 * Creates fixed contents for CDA Element hl7ServiceEvent
	 *
	 * @param classCode the desired fixed value for this argument.
	 * @param moodCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ServiceEvent createHl7ServiceEventFixedValue(String classCode, String moodCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040ServiceEvent retVal = factory.createPOCDMT000040ServiceEvent();
		retVal.getClassCode().add(classCode);
		retVal.getMoodCode().add(moodCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Attribute typeCode
	 */
	private void createTypeCodeFixedValue(String value) {
		this.myTypeCode = value;
	}

	/**
	 * Gets the hl7ServiceEvent
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ServiceEvent getHl7ServiceEvent() {
		return serviceEvent;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getTemplateId() != null)
			if (getTemplateId().size() > 0)
				retVal = getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the member myTypeCode
	 */
	public String getPredefinedTypeCode() {
		return myTypeCode;
	}

	/**
	 * Sets the hl7ServiceEvent
	 */
	public void setHl7ServiceEvent(org.ehealth_connector.common.hl7cdar2.POCDMT000040ServiceEvent value) {
		this.serviceEvent = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
