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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.cda.ch.emed.v097;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;

/**
 * CDAcomponentOf
 *
 * Template description: Template CDA componentOf (prototype, directly derived from POCD_RM000040 MIF)
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.840.1.113883.10.12.113
 * Effective date: 2005-09-07 00:00:00
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class CdacomponentOf extends org.husky.common.hl7cdar2.POCDMT000040Component1 {

	public CdacomponentOf() {
		super.setTypeCode(org.husky.common.hl7cdar2.ActRelationshipHasComponent.COMP);
		super.setEncompassingEncounter(createHl7EncompassingEncounterFixedValue("ENC", "EVN"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7EncompassingEncounter
	 *
	 * @param classCode
	 *            the desired fixed value for this argument.
	 * @param moodCode
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter createHl7EncompassingEncounterFixedValue(
			String classCode, String moodCode) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter retVal = factory
				.createPOCDMT000040EncompassingEncounter();
		retVal.getClassCode().add(classCode);
		retVal.getMoodCode().add(moodCode);
		return retVal;
	}

	/**
	 * Gets the hl7EncompassingEncounter
	 */
	public org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter getHl7EncompassingEncounter() {
		return encompassingEncounter;
	}

	/**
	 * Sets the hl7EncompassingEncounter
	 */
	public void setHl7EncompassingEncounter(
			org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter value) {
		this.encompassingEncounter = value;
	}
}
