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
package org.ehealth_connector.common.model;

import org.ehealth_connector.common.hl7cdar2.POCDMT000040AuthoringDevice;
import org.ehealth_connector.common.hl7cdar2.SC;


/**
 * The Class AuthoringDevice. The element represents a system or device which
 * produced the document.
 */
public class AuthoringDevice {

	/** The MDHT authoring device object. */
	private POCDMT000040AuthoringDevice mAuthoringDevice;

	/**
	 * Instantiates a new authoring device.
	 */
	public AuthoringDevice() {
		mAuthoringDevice = new POCDMT000040AuthoringDevice();
	}

	/**
	 * Instantiates a new authoring device.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public AuthoringDevice(POCDMT000040AuthoringDevice mdht) {
		mAuthoringDevice = mdht;
	}

	/**
	 * Instantiates a new authoring device.
	 *
	 * @param name
	 *            the name
	 */
	public AuthoringDevice(String name) {
		this();
		setSoftwareName(name);
	}

	/**
	 * Gets the manufacturer name.
	 *
	 * @return the manufacturer name
	 */
	public String getManufacturerName() {
		if ((mAuthoringDevice.getManufacturerModelName() != null)
				&& (mAuthoringDevice.getManufacturerModelName().xmlContent != null)) {
			return mAuthoringDevice.getManufacturerModelName().xmlContent;
		}
		return null;
	}

	/**
	 * Gets the mdht.
	 *
	 * @return the mdht
	 */
	public POCDMT000040AuthoringDevice getMdht() {
		return mAuthoringDevice;
	}

	/**
	 * Gets the software name.
	 *
	 * @return the software name
	 */
	public String getSoftwareName() {
		if ((mAuthoringDevice.getSoftwareName() != null)
				&& (mAuthoringDevice.getSoftwareName().xmlContent != null)) {
			return mAuthoringDevice.getSoftwareName().xmlContent;
		}
		return null;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param name
	 *            the new manufacturer name
	 */
	public void setManufacturerName(String name) {
		final var sc = new SC();
		sc.xmlContent = name;
		mAuthoringDevice.setManufacturerModelName(sc);
	}

	/**
	 * Sets the software name.
	 *
	 * @param name
	 *            the new software name
	 */
	public void setSoftwareName(String name) {
		final var sc = new SC();
		sc.xmlContent = name;
		mAuthoringDevice.setSoftwareName(sc);
	}
}
