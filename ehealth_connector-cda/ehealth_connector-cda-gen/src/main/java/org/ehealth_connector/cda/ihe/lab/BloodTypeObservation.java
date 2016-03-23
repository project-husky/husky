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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class BloodTypeObservation. Represents a blood type.
 */
public class BloodTypeObservation extends
		MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.BloodTypeObservation> {

	/**
	 * Instantiates a new blood type observation.
	 */
	protected BloodTypeObservation() {
		super(LABFactory.eINSTANCE.createBloodTypeObservation());
	}

	/**
	 * Instantiates a new blood type observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	protected BloodTypeObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.BloodTypeObservation mdht) {
		super(mdht);
	}
}
