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

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.7
 * Template description: This CAN be used to indicate another executing laboratory in the CDA body. When executing laboratories are specified, the following applies:
 * - If all tests have been performed by the same laboratory, this element MUST be specified in the header using the Laboratory Performer (documentationOf).
 * - If multple laboratories have provided results for this document, they must be specified in the body using this element (at entry, organizer or observation level, depending on the extent of the results delivered by the appropriate laboratory).
 * - All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
 *
 * Element description: All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
 */
public class ChpalmEntryLaboratoryPerformer {

	public ChpalmEntryLaboratoryPerformer() {
		templateId.add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.7"));
		templateId.add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.7"));
	// chpalm_entry_LaboratoryPerformer/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.7";
	// chpalm_entry_LaboratoryPerformer/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.3.1.7";
	}

	/**
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity assignedEntity;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.II> templateId = new ArrayList<org.ehealth_connector.common.hl7cdar2.II>();

	/**
	 * Timestamp of the last delivery of this laboratory to the document.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.TS time;

	/**
	 * Creates fixed contents for hl7TemplateId
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
	 * Gets the hl7AssignedEntity
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return assignedEntity;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (templateId != null)
			if (templateId.size() > 0)
				retVal = templateId.get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Time
	 * Timestamp of the last delivery of this laboratory to the document.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7Time() {
		return time;
	}

	/**
	 * Sets the hl7AssignedEntity
	 * All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
	 */
	public void setHl7AssignedEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		this.assignedEntity = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		templateId.clear();
		templateId.add(value);
	}

	/**
	 * Sets the hl7Time
	 * Timestamp of the last delivery of this laboratory to the document.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.TS value) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS ivlts = factory.createIVLTS();
		ivlts.setValue(value.getValue());
		this.time = ivlts;
	}
}
