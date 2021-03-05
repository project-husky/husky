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
package org.ehealth_connector.cda.ch.emed.v097;

import javax.annotation.Generated;

/**
 * cdach_other_DeviceCompilationWithName
 *
 * Template description: Reusable template wherever a device with required name is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.A device is either a physical device (e.g. analyzer with which laboratory results are determined) or a software (e.g. laboratory information system, in which laboratory results are documented).
 *
 * Element description: The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.756.5.30.1.1.10.9.21
 * Effective date: 2018-04-18 00:00:00
 * Version: 2017
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class CdachOtherDeviceCompilationWithName
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040AuthoringDevice {

	public CdachOtherDeviceCompilationWithName() {
	}

	/**
	 * Gets the hl7ManufacturerModelName The model name of the device MAY be
	 * declared.
	 */
	public org.ehealth_connector.common.hl7cdar2.SC getHl7ManufacturerModelName() {
		return manufacturerModelName;
	}

	/**
	 * Gets the hl7SoftwareName The name of the device MUST be
	 * declared.Note:Altough this element is called softwareName, it contains
	 * also the name of physical devices (e.g. laboratory analyzer).
	 */
	public org.ehealth_connector.common.hl7cdar2.SC getHl7SoftwareName() {
		return softwareName;
	}

	/**
	 * Sets the hl7ManufacturerModelName The model name of the device MAY be
	 * declared.
	 */
	public void setHl7ManufacturerModelName(org.ehealth_connector.common.hl7cdar2.SC value) {
		this.manufacturerModelName = value;
	}

	/**
	 * Sets the hl7SoftwareName The name of the device MUST be
	 * declared.Note:Altough this element is called softwareName, it contains
	 * also the name of physical devices (e.g. laboratory analyzer).
	 */
	public void setHl7SoftwareName(org.ehealth_connector.common.hl7cdar2.SC value) {
		this.softwareName = value;
	}
}
