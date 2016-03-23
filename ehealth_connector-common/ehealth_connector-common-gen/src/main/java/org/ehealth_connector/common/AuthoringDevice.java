/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.SC;

/**
 * The Class AuthoringDevice. The element represents a system or device which
 * produced the document.
 */
public class AuthoringDevice {

	/** The m authoring device. */
	org.openhealthtools.mdht.uml.cda.AuthoringDevice mAuthoringDevice;

	/**
	 * Instantiates a new authoring device.
	 */
	public AuthoringDevice() {
		mAuthoringDevice = CDAFactory.eINSTANCE.createAuthoringDevice();
	}

	/**
	 * Instantiates a new authoring device.
	 *
	 * @param mdht
	 *          the mdht
	 */
	public AuthoringDevice(org.openhealthtools.mdht.uml.cda.AuthoringDevice mdht) {
		mAuthoringDevice = mdht;
	}

	/**
	 * Instantiates a new authoring device.
	 *
	 * @param name
	 *          the name
	 */
	public AuthoringDevice(String name) {
		this();
		setSoftwareName(name);
	}

	/**
	 * Copy.
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. authoring device
	 */
	public org.openhealthtools.mdht.uml.cda.AuthoringDevice copy() {
		return EcoreUtil.copy(mAuthoringDevice);
	}

	/**
	 * Gets the mdht.
	 *
	 * @return the mdht
	 */
	public org.openhealthtools.mdht.uml.cda.AuthoringDevice getMdht() {
		return mAuthoringDevice;
	}

	/**
	 * Gets the software name.
	 *
	 * @return the software name
	 */
	public String getSoftwareName() {
		if (mAuthoringDevice.getSoftwareName() != null
				&& mAuthoringDevice.getSoftwareName().getText() != null) {
			return mAuthoringDevice.getSoftwareName().getText();
		}
		return null;
	}

	/**
	 * Sets the software name.
	 *
	 * @param name
	 *          the new software name
	 */
	public void setSoftwareName(String name) {
		SC sc = DatatypesFactory.eINSTANCE.createSC();
		sc.addText(name);
		mAuthoringDevice.setSoftwareName(sc);
	}
}
